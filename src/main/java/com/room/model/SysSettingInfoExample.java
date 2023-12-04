package com.room.model;
import java.util.ArrayList;
import java.util.List;
public class SysSettingInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public SysSettingInfoExample() {
        oredCriteria = new ArrayList<>();
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
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    public int getStartRow() {
        return startRow;
    }
    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }
    public int getPageRows() {
        return pageRows;
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
            criteria = new ArrayList<>();
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
  public Criteria andIdIsNotNull(){
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
		  addCriterion("id >=", value, "Id");
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
    public Criteria andIdLike(Integer value) {
		  addCriterion("id like", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotLike(Integer value) {
		  addCriterion("id not like", value, "id");
		return (Criteria) this;
		}
 public Criteria andStartTimeIsNull() {
		 addCriterion("start_time is null");
		return (Criteria) this;
		}
  public Criteria andStartTimeIsNotNull(){
		addCriterion("start_time is not null");
		return (Criteria) this;
		}
  public Criteria andStartTimeEqualTo(Integer value) {
		  addCriterion("start_time =", value, "startTime");
		return (Criteria) this;
		}
   public Criteria andStartTimeNotEqualTo(Integer value) {
		  addCriterion("start_time <>", value, "startTime");
		return (Criteria) this;
		}
    public Criteria andStartTimeGreaterThan(Integer value) {
		 addCriterion("start_time >", value, "startTime");
		return (Criteria) this;
		}
  public Criteria andStartTimeGreaterThanOrEqualTo(Integer value) {
		  addCriterion("start_time >=", value, "StartTime");
		return (Criteria) this;
		}
   public Criteria andStartTimeLessThan(Integer value) {
		  addCriterion("start_time <", value, "startTime");
		return (Criteria) this;
		}
    public Criteria andStartTimeLessThanOrEqualTo(Integer value) {
		  addCriterion("start_time <=", value, "startTime");
		return (Criteria) this;
		}
    public Criteria andStartTimeIn(List<Integer> values) {
		  addCriterion("start_time in", values, "startTime");
		return (Criteria) this;
		}
    public Criteria andStartTimeNotIn(List<Integer> values) {
		  addCriterion("start_time not in", values, "startTime");
		return (Criteria) this;
		}
     public Criteria andStartTimeBetween(Integer value1, Integer value2) {
		   addCriterion("start_time between", value1, value2, "startTime");
		return (Criteria) this;
		}
     public Criteria andStartTimeNotBetween(Integer value1, Integer value2) {
		   addCriterion("start_time not between", value1, value2, "startTime");
		return (Criteria) this;
		}
    public Criteria andStartTimeLike(Integer value) {
		  addCriterion("start_time like", value, "startTime");
		return (Criteria) this;
		}
    public Criteria andStartTimeNotLike(Integer value) {
		  addCriterion("start_time not like", value, "startTime");
		return (Criteria) this;
		}
 public Criteria andEndTimeIsNull() {
		 addCriterion("end_time is null");
		return (Criteria) this;
		}
  public Criteria andEndTimeIsNotNull(){
		addCriterion("end_time is not null");
		return (Criteria) this;
		}
  public Criteria andEndTimeEqualTo(Integer value) {
		  addCriterion("end_time =", value, "endTime");
		return (Criteria) this;
		}
   public Criteria andEndTimeNotEqualTo(Integer value) {
		  addCriterion("end_time <>", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeGreaterThan(Integer value) {
		 addCriterion("end_time >", value, "endTime");
		return (Criteria) this;
		}
  public Criteria andEndTimeGreaterThanOrEqualTo(Integer value) {
		  addCriterion("end_time >=", value, "EndTime");
		return (Criteria) this;
		}
   public Criteria andEndTimeLessThan(Integer value) {
		  addCriterion("end_time <", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeLessThanOrEqualTo(Integer value) {
		  addCriterion("end_time <=", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeIn(List<Integer> values) {
		  addCriterion("end_time in", values, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeNotIn(List<Integer> values) {
		  addCriterion("end_time not in", values, "endTime");
		return (Criteria) this;
		}
     public Criteria andEndTimeBetween(Integer value1, Integer value2) {
		   addCriterion("end_time between", value1, value2, "endTime");
		return (Criteria) this;
		}
     public Criteria andEndTimeNotBetween(Integer value1, Integer value2) {
		   addCriterion("end_time not between", value1, value2, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeLike(Integer value) {
		  addCriterion("end_time like", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeNotLike(Integer value) {
		  addCriterion("end_time not like", value, "endTime");
		return (Criteria) this;
		}
 public Criteria andPriceIsNull() {
		 addCriterion("price is null");
		return (Criteria) this;
		}
  public Criteria andPriceIsNotNull(){
		addCriterion("price is not null");
		return (Criteria) this;
		}
  public Criteria andPriceEqualTo(Double value) {
		  addCriterion("price =", value, "price");
		return (Criteria) this;
		}
   public Criteria andPriceNotEqualTo(Double value) {
		  addCriterion("price <>", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceGreaterThan(Double value) {
		 addCriterion("price >", value, "price");
		return (Criteria) this;
		}
  public Criteria andPriceGreaterThanOrEqualTo(Double value) {
		  addCriterion("price >=", value, "Price");
		return (Criteria) this;
		}
   public Criteria andPriceLessThan(Double value) {
		  addCriterion("price <", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceLessThanOrEqualTo(Double value) {
		  addCriterion("price <=", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceIn(List<Double> values) {
		  addCriterion("price in", values, "price");
		return (Criteria) this;
		}
    public Criteria andPriceNotIn(List<Double> values) {
		  addCriterion("price not in", values, "price");
		return (Criteria) this;
		}
     public Criteria andPriceBetween(Double value1, Double value2) {
		   addCriterion("price between", value1, value2, "price");
		return (Criteria) this;
		}
     public Criteria andPriceNotBetween(Double value1, Double value2) {
		   addCriterion("price not between", value1, value2, "price");
		return (Criteria) this;
		}
    public Criteria andPriceLike(Double value) {
		  addCriterion("price like", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceNotLike(Double value) {
		  addCriterion("price not like", value, "price");
		return (Criteria) this;
		}
 public Criteria andShopNameIsNull() {
		 addCriterion("shop_name is null");
		return (Criteria) this;
		}
  public Criteria andShopNameIsNotNull(){
		addCriterion("shop_name is not null");
		return (Criteria) this;
		}
  public Criteria andShopNameEqualTo(String value) {
		  addCriterion("shop_name =", value, "shopName");
		return (Criteria) this;
		}
   public Criteria andShopNameNotEqualTo(String value) {
		  addCriterion("shop_name <>", value, "shopName");
		return (Criteria) this;
		}
    public Criteria andShopNameGreaterThan(String value) {
		 addCriterion("shop_name >", value, "shopName");
		return (Criteria) this;
		}
  public Criteria andShopNameGreaterThanOrEqualTo(String value) {
		  addCriterion("shop_name >=", value, "ShopName");
		return (Criteria) this;
		}
   public Criteria andShopNameLessThan(String value) {
		  addCriterion("shop_name <", value, "shopName");
		return (Criteria) this;
		}
    public Criteria andShopNameLessThanOrEqualTo(String value) {
		  addCriterion("shop_name <=", value, "shopName");
		return (Criteria) this;
		}
    public Criteria andShopNameIn(List<String> values) {
		  addCriterion("shop_name in", values, "shopName");
		return (Criteria) this;
		}
    public Criteria andShopNameNotIn(List<String> values) {
		  addCriterion("shop_name not in", values, "shopName");
		return (Criteria) this;
		}
     public Criteria andShopNameBetween(String value1, String value2) {
		   addCriterion("shop_name between", value1, value2, "shopName");
		return (Criteria) this;
		}
     public Criteria andShopNameNotBetween(String value1, String value2) {
		   addCriterion("shop_name not between", value1, value2, "shopName");
		return (Criteria) this;
		}
    public Criteria andShopNameLike(String value) {
		  addCriterion("shop_name like", value, "shopName");
		return (Criteria) this;
		}
    public Criteria andShopNameNotLike(String value) {
		  addCriterion("shop_name not like", value, "shopName");
		return (Criteria) this;
		}
 public Criteria andShopIntroIsNull() {
		 addCriterion("shop_intro is null");
		return (Criteria) this;
		}
  public Criteria andShopIntroIsNotNull(){
		addCriterion("shop_intro is not null");
		return (Criteria) this;
		}
  public Criteria andShopIntroEqualTo(String value) {
		  addCriterion("shop_intro =", value, "shopIntro");
		return (Criteria) this;
		}
   public Criteria andShopIntroNotEqualTo(String value) {
		  addCriterion("shop_intro <>", value, "shopIntro");
		return (Criteria) this;
		}
    public Criteria andShopIntroGreaterThan(String value) {
		 addCriterion("shop_intro >", value, "shopIntro");
		return (Criteria) this;
		}
  public Criteria andShopIntroGreaterThanOrEqualTo(String value) {
		  addCriterion("shop_intro >=", value, "ShopIntro");
		return (Criteria) this;
		}
   public Criteria andShopIntroLessThan(String value) {
		  addCriterion("shop_intro <", value, "shopIntro");
		return (Criteria) this;
		}
    public Criteria andShopIntroLessThanOrEqualTo(String value) {
		  addCriterion("shop_intro <=", value, "shopIntro");
		return (Criteria) this;
		}
    public Criteria andShopIntroIn(List<String> values) {
		  addCriterion("shop_intro in", values, "shopIntro");
		return (Criteria) this;
		}
    public Criteria andShopIntroNotIn(List<String> values) {
		  addCriterion("shop_intro not in", values, "shopIntro");
		return (Criteria) this;
		}
     public Criteria andShopIntroBetween(String value1, String value2) {
		   addCriterion("shop_intro between", value1, value2, "shopIntro");
		return (Criteria) this;
		}
     public Criteria andShopIntroNotBetween(String value1, String value2) {
		   addCriterion("shop_intro not between", value1, value2, "shopIntro");
		return (Criteria) this;
		}
    public Criteria andShopIntroLike(String value) {
		  addCriterion("shop_intro like", value, "shopIntro");
		return (Criteria) this;
		}
    public Criteria andShopIntroNotLike(String value) {
		  addCriterion("shop_intro not like", value, "shopIntro");
		return (Criteria) this;
		}
 public Criteria andAddressIsNull() {
		 addCriterion("address is null");
		return (Criteria) this;
		}
  public Criteria andAddressIsNotNull(){
		addCriterion("address is not null");
		return (Criteria) this;
		}
  public Criteria andAddressEqualTo(String value) {
		  addCriterion("address =", value, "address");
		return (Criteria) this;
		}
   public Criteria andAddressNotEqualTo(String value) {
		  addCriterion("address <>", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressGreaterThan(String value) {
		 addCriterion("address >", value, "address");
		return (Criteria) this;
		}
  public Criteria andAddressGreaterThanOrEqualTo(String value) {
		  addCriterion("address >=", value, "Address");
		return (Criteria) this;
		}
   public Criteria andAddressLessThan(String value) {
		  addCriterion("address <", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressLessThanOrEqualTo(String value) {
		  addCriterion("address <=", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressIn(List<String> values) {
		  addCriterion("address in", values, "address");
		return (Criteria) this;
		}
    public Criteria andAddressNotIn(List<String> values) {
		  addCriterion("address not in", values, "address");
		return (Criteria) this;
		}
     public Criteria andAddressBetween(String value1, String value2) {
		   addCriterion("address between", value1, value2, "address");
		return (Criteria) this;
		}
     public Criteria andAddressNotBetween(String value1, String value2) {
		   addCriterion("address not between", value1, value2, "address");
		return (Criteria) this;
		}
    public Criteria andAddressLike(String value) {
		  addCriterion("address like", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressNotLike(String value) {
		  addCriterion("address not like", value, "address");
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
