package com.oracle.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProSnIsNull() {
            addCriterion("pro_sn is null");
            return (Criteria) this;
        }

        public Criteria andProSnIsNotNull() {
            addCriterion("pro_sn is not null");
            return (Criteria) this;
        }

        public Criteria andProSnEqualTo(String value) {
            addCriterion("pro_sn =", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnNotEqualTo(String value) {
            addCriterion("pro_sn <>", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnGreaterThan(String value) {
            addCriterion("pro_sn >", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnGreaterThanOrEqualTo(String value) {
            addCriterion("pro_sn >=", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnLessThan(String value) {
            addCriterion("pro_sn <", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnLessThanOrEqualTo(String value) {
            addCriterion("pro_sn <=", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnLike(String value) {
            addCriterion("pro_sn like", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnNotLike(String value) {
            addCriterion("pro_sn not like", value, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnIn(List<String> values) {
            addCriterion("pro_sn in", values, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnNotIn(List<String> values) {
            addCriterion("pro_sn not in", values, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnBetween(String value1, String value2) {
            addCriterion("pro_sn between", value1, value2, "proSn");
            return (Criteria) this;
        }

        public Criteria andProSnNotBetween(String value1, String value2) {
            addCriterion("pro_sn not between", value1, value2, "proSn");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNull() {
            addCriterion("pro_price is null");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNotNull() {
            addCriterion("pro_price is not null");
            return (Criteria) this;
        }

        public Criteria andProPriceEqualTo(Double value) {
            addCriterion("pro_price =", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotEqualTo(Double value) {
            addCriterion("pro_price <>", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThan(Double value) {
            addCriterion("pro_price >", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_price >=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThan(Double value) {
            addCriterion("pro_price <", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThanOrEqualTo(Double value) {
            addCriterion("pro_price <=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceIn(List<Double> values) {
            addCriterion("pro_price in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotIn(List<Double> values) {
            addCriterion("pro_price not in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceBetween(Double value1, Double value2) {
            addCriterion("pro_price between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotBetween(Double value1, Double value2) {
            addCriterion("pro_price not between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProNumIsNull() {
            addCriterion("pro_num is null");
            return (Criteria) this;
        }

        public Criteria andProNumIsNotNull() {
            addCriterion("pro_num is not null");
            return (Criteria) this;
        }

        public Criteria andProNumEqualTo(Integer value) {
            addCriterion("pro_num =", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotEqualTo(Integer value) {
            addCriterion("pro_num <>", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThan(Integer value) {
            addCriterion("pro_num >", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_num >=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThan(Integer value) {
            addCriterion("pro_num <", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThanOrEqualTo(Integer value) {
            addCriterion("pro_num <=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumIn(List<Integer> values) {
            addCriterion("pro_num in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotIn(List<Integer> values) {
            addCriterion("pro_num not in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumBetween(Integer value1, Integer value2) {
            addCriterion("pro_num between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_num not between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andProImgIsNull() {
            addCriterion("pro_img is null");
            return (Criteria) this;
        }

        public Criteria andProImgIsNotNull() {
            addCriterion("pro_img is not null");
            return (Criteria) this;
        }

        public Criteria andProImgEqualTo(String value) {
            addCriterion("pro_img =", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgNotEqualTo(String value) {
            addCriterion("pro_img <>", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgGreaterThan(String value) {
            addCriterion("pro_img >", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgGreaterThanOrEqualTo(String value) {
            addCriterion("pro_img >=", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgLessThan(String value) {
            addCriterion("pro_img <", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgLessThanOrEqualTo(String value) {
            addCriterion("pro_img <=", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgLike(String value) {
            addCriterion("pro_img like", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgNotLike(String value) {
            addCriterion("pro_img not like", value, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgIn(List<String> values) {
            addCriterion("pro_img in", values, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgNotIn(List<String> values) {
            addCriterion("pro_img not in", values, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgBetween(String value1, String value2) {
            addCriterion("pro_img between", value1, value2, "proImg");
            return (Criteria) this;
        }

        public Criteria andProImgNotBetween(String value1, String value2) {
            addCriterion("pro_img not between", value1, value2, "proImg");
            return (Criteria) this;
        }

        public Criteria andProFullnameIsNull() {
            addCriterion("pro_fullname is null");
            return (Criteria) this;
        }

        public Criteria andProFullnameIsNotNull() {
            addCriterion("pro_fullname is not null");
            return (Criteria) this;
        }

        public Criteria andProFullnameEqualTo(String value) {
            addCriterion("pro_fullname =", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameNotEqualTo(String value) {
            addCriterion("pro_fullname <>", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameGreaterThan(String value) {
            addCriterion("pro_fullname >", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_fullname >=", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameLessThan(String value) {
            addCriterion("pro_fullname <", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameLessThanOrEqualTo(String value) {
            addCriterion("pro_fullname <=", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameLike(String value) {
            addCriterion("pro_fullname like", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameNotLike(String value) {
            addCriterion("pro_fullname not like", value, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameIn(List<String> values) {
            addCriterion("pro_fullname in", values, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameNotIn(List<String> values) {
            addCriterion("pro_fullname not in", values, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameBetween(String value1, String value2) {
            addCriterion("pro_fullname between", value1, value2, "proFullname");
            return (Criteria) this;
        }

        public Criteria andProFullnameNotBetween(String value1, String value2) {
            addCriterion("pro_fullname not between", value1, value2, "proFullname");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}