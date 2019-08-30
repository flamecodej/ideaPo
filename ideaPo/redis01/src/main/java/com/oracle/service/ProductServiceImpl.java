package com.oracle.service;

import com.oracle.mapper.ProductMapper;
import com.oracle.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService {

    // 缓存前缀  ：
    private static final String CACHE_PREFIX = "pro:";

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 在 执行查询时  先进性 redis 的 操作  获取到 数据  判断是否存在  如果存在则返回  没有时  将查询数据库 ，
     *          同时将数据存在redis(redis)中
     *  当数据  出现  更新(写操作时) 根据 业务需求  及性能选择更新  缓存
     * @Title: findAll
     * @param
     * @return java.util.List<com.oracle.pojo.Product>
     * @author: Flame
     * @since: 2019/7/16 14:37
     */
    @Override
    public List<Product> findAll() {
        // list
        final String CACHE_KEY = CACHE_PREFIX + "list";
        if(this.redisTemplate.boundValueOps(CACHE_KEY).get()==null){
            System.out.println("redis为空");
            // 此时 缓存没有数据
            // 执行查询数据库   落库
            List<Product> listPo = this.productMapper.selectByExample(null);
            System.out.println("从mysql中获取");
            // 存放在redis 后 (并设置 缓存时间 在 30分钟 后   失效 )
            this.redisTemplate.boundValueOps(CACHE_KEY).set(listPo,30,TimeUnit.MINUTES);
            return listPo;
        }
        List<Product> list = (List<Product>) this.redisTemplate.boundValueOps(CACHE_KEY).get();
        System.out.println("缓存中的数据");
        return list;
    }

    @Override
    public Product getProById(Integer id) {
        //  当单个热点数据 为 热点数据  时   可以将 这个数据  存放  redis  hash  存储
        // key field value
        // 相同的 key 再次 执行时 覆盖
        final String CACHE_KEY = CACHE_PREFIX + "pro";
        if(this.redisTemplate.boundHashOps(CACHE_KEY).get(id+"")==null){
            Product pt = this.productMapper.selectByPrimaryKey(id);
            this.redisTemplate.boundHashOps(CACHE_KEY).put(id+"",pt);
            return pt;
        }
        Product product = (Product) this.redisTemplate.boundHashOps(CACHE_KEY).get(id+"");
        return product;
    }

    @Override
    public void insertPro(Product product) {
        final String CACHE_KEY = CACHE_PREFIX + "add";
        this.productMapper.insertSelective(product);
        this.redisTemplate.boundHashOps(CACHE_KEY).put(product.getId()+"",product);
    }

    @Override
    public void updatePro(Product product) {
        final String CACHE_KEY = CACHE_PREFIX + "update";
        this.productMapper.updateByPrimaryKeySelective(product);
        this.redisTemplate.boundHashOps(CACHE_KEY).put(product.getId()+"",product);
    }

    @Override
    public void delPro(Integer id) {
        final String CACHE_KEY = CACHE_PREFIX + "del";
        this.productMapper.deleteByPrimaryKey(id);
        // 删除
        if(this.redisTemplate.boundHashOps(CACHE_KEY).get(id+"")!=null){
            // 缓存中没有
            this.redisTemplate.boundHashOps(CACHE_KEY).delete(id+"");
        }
    }
}
