package com.room.model;
import java.util.ArrayList;
import java.util.List;
public class OrderInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public OrderInfoExample() {
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
 public Criteria andOrderNoIsNull() {
		 addCriterion("order_no is null");
		return (Criteria) this;
		}
  public Criteria andOrderNoIsNotNull(){
		addCriterion("order_no is not null");
		return (Criteria) this;
		}
  public Criteria andOrderNoEqualTo(String value) {
		  addCriterion("order_no =", value, "orderNo");
		return (Criteria) this;
		}
   public Criteria andOrderNoNotEqualTo(String value) {
		  addCriterion("order_no <>", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoGreaterThan(String value) {
		 addCriterion("order_no >", value, "orderNo");
		return (Criteria) this;
		}
  public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
		  addCriterion("order_no >=", value, "OrderNo");
		return (Criteria) this;
		}
   public Criteria andOrderNoLessThan(String value) {
		  addCriterion("order_no <", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoLessThanOrEqualTo(String value) {
		  addCriterion("order_no <=", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoIn(List<String> values) {
		  addCriterion("order_no in", values, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoNotIn(List<String> values) {
		  addCriterion("order_no not in", values, "orderNo");
		return (Criteria) this;
		}
     public Criteria andOrderNoBetween(String value1, String value2) {
		   addCriterion("order_no between", value1, value2, "orderNo");
		return (Criteria) this;
		}
     public Criteria andOrderNoNotBetween(String value1, String value2) {
		   addCriterion("order_no not between", value1, value2, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoLike(String value) {
		  addCriterion("order_no like", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoNotLike(String value) {
		  addCriterion("order_no not like", value, "orderNo");
		return (Criteria) this;
		}
 public Criteria andDeskIdIsNull() {
		 addCriterion("desk_id is null");
		return (Criteria) this;
		}
  public Criteria andDeskIdIsNotNull(){
		addCriterion("desk_id is not null");
		return (Criteria) this;
		}
  public Criteria andDeskIdEqualTo(Integer value) {
		  addCriterion("desk_id =", value, "deskId");
		return (Criteria) this;
		}
   public Criteria andDeskIdNotEqualTo(Integer value) {
		  addCriterion("desk_id <>", value, "deskId");
		return (Criteria) this;
		}
    public Criteria andDeskIdGreaterThan(Integer value) {
		 addCriterion("desk_id >", value, "deskId");
		return (Criteria) this;
		}
  public Criteria andDeskIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("desk_id >=", value, "DeskId");
		return (Criteria) this;
		}
   public Criteria andDeskIdLessThan(Integer value) {
		  addCriterion("desk_id <", value, "deskId");
		return (Criteria) this;
		}
    public Criteria andDeskIdLessThanOrEqualTo(Integer value) {
		  addCriterion("desk_id <=", value, "deskId");
		return (Criteria) this;
		}
    public Criteria andDeskIdIn(List<Integer> values) {
		  addCriterion("desk_id in", values, "deskId");
		return (Criteria) this;
		}
    public Criteria andDeskIdNotIn(List<Integer> values) {
		  addCriterion("desk_id not in", values, "deskId");
		return (Criteria) this;
		}
     public Criteria andDeskIdBetween(Integer value1, Integer value2) {
		   addCriterion("desk_id between", value1, value2, "deskId");
		return (Criteria) this;
		}
     public Criteria andDeskIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("desk_id not between", value1, value2, "deskId");
		return (Criteria) this;
		}
    public Criteria andDeskIdLike(Integer value) {
		  addCriterion("desk_id like", value, "deskId");
		return (Criteria) this;
		}
    public Criteria andDeskIdNotLike(Integer value) {
		  addCriterion("desk_id not like", value, "deskId");
		return (Criteria) this;
		}
 public Criteria andOrderDateIsNull() {
		 addCriterion("order_date is null");
		return (Criteria) this;
		}
  public Criteria andOrderDateIsNotNull(){
		addCriterion("order_date is not null");
		return (Criteria) this;
		}
  public Criteria andOrderDateEqualTo(String value) {
		  addCriterion("order_date =", value, "orderDate");
		return (Criteria) this;
		}
   public Criteria andOrderDateNotEqualTo(String value) {
		  addCriterion("order_date <>", value, "orderDate");
		return (Criteria) this;
		}
    public Criteria andOrderDateGreaterThan(String value) {
		 addCriterion("order_date >", value, "orderDate");
		return (Criteria) this;
		}
  public Criteria andOrderDateGreaterThanOrEqualTo(String value) {
		  addCriterion("order_date >=", value, "OrderDate");
		return (Criteria) this;
		}
   public Criteria andOrderDateLessThan(String value) {
		  addCriterion("order_date <", value, "orderDate");
		return (Criteria) this;
		}
    public Criteria andOrderDateLessThanOrEqualTo(String value) {
		  addCriterion("order_date <=", value, "orderDate");
		return (Criteria) this;
		}
    public Criteria andOrderDateIn(List<String> values) {
		  addCriterion("order_date in", values, "orderDate");
		return (Criteria) this;
		}
    public Criteria andOrderDateNotIn(List<String> values) {
		  addCriterion("order_date not in", values, "orderDate");
		return (Criteria) this;
		}
     public Criteria andOrderDateBetween(String value1, String value2) {
		   addCriterion("order_date between", value1, value2, "orderDate");
		return (Criteria) this;
		}
     public Criteria andOrderDateNotBetween(String value1, String value2) {
		   addCriterion("order_date not between", value1, value2, "orderDate");
		return (Criteria) this;
		}
    public Criteria andOrderDateLike(String value) {
		  addCriterion("order_date like", value, "orderDate");
		return (Criteria) this;
		}
    public Criteria andOrderDateNotLike(String value) {
		  addCriterion("order_date not like", value, "orderDate");
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
 public Criteria andTotalHoursIsNull() {
		 addCriterion("total_hours is null");
		return (Criteria) this;
		}
  public Criteria andTotalHoursIsNotNull(){
		addCriterion("total_hours is not null");
		return (Criteria) this;
		}
  public Criteria andTotalHoursEqualTo(Integer value) {
		  addCriterion("total_hours =", value, "totalHours");
		return (Criteria) this;
		}
   public Criteria andTotalHoursNotEqualTo(Integer value) {
		  addCriterion("total_hours <>", value, "totalHours");
		return (Criteria) this;
		}
    public Criteria andTotalHoursGreaterThan(Integer value) {
		 addCriterion("total_hours >", value, "totalHours");
		return (Criteria) this;
		}
  public Criteria andTotalHoursGreaterThanOrEqualTo(Integer value) {
		  addCriterion("total_hours >=", value, "TotalHours");
		return (Criteria) this;
		}
   public Criteria andTotalHoursLessThan(Integer value) {
		  addCriterion("total_hours <", value, "totalHours");
		return (Criteria) this;
		}
    public Criteria andTotalHoursLessThanOrEqualTo(Integer value) {
		  addCriterion("total_hours <=", value, "totalHours");
		return (Criteria) this;
		}
    public Criteria andTotalHoursIn(List<Integer> values) {
		  addCriterion("total_hours in", values, "totalHours");
		return (Criteria) this;
		}
    public Criteria andTotalHoursNotIn(List<Integer> values) {
		  addCriterion("total_hours not in", values, "totalHours");
		return (Criteria) this;
		}
     public Criteria andTotalHoursBetween(Integer value1, Integer value2) {
		   addCriterion("total_hours between", value1, value2, "totalHours");
		return (Criteria) this;
		}
     public Criteria andTotalHoursNotBetween(Integer value1, Integer value2) {
		   addCriterion("total_hours not between", value1, value2, "totalHours");
		return (Criteria) this;
		}
    public Criteria andTotalHoursLike(Integer value) {
		  addCriterion("total_hours like", value, "totalHours");
		return (Criteria) this;
		}
    public Criteria andTotalHoursNotLike(Integer value) {
		  addCriterion("total_hours not like", value, "totalHours");
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
 public Criteria andTotalAmountIsNull() {
		 addCriterion("total_amount is null");
		return (Criteria) this;
		}
  public Criteria andTotalAmountIsNotNull(){
		addCriterion("total_amount is not null");
		return (Criteria) this;
		}
  public Criteria andTotalAmountEqualTo(Double value) {
		  addCriterion("total_amount =", value, "totalAmount");
		return (Criteria) this;
		}
   public Criteria andTotalAmountNotEqualTo(Double value) {
		  addCriterion("total_amount <>", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountGreaterThan(Double value) {
		 addCriterion("total_amount >", value, "totalAmount");
		return (Criteria) this;
		}
  public Criteria andTotalAmountGreaterThanOrEqualTo(Double value) {
		  addCriterion("total_amount >=", value, "TotalAmount");
		return (Criteria) this;
		}
   public Criteria andTotalAmountLessThan(Double value) {
		  addCriterion("total_amount <", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountLessThanOrEqualTo(Double value) {
		  addCriterion("total_amount <=", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountIn(List<Double> values) {
		  addCriterion("total_amount in", values, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountNotIn(List<Double> values) {
		  addCriterion("total_amount not in", values, "totalAmount");
		return (Criteria) this;
		}
     public Criteria andTotalAmountBetween(Double value1, Double value2) {
		   addCriterion("total_amount between", value1, value2, "totalAmount");
		return (Criteria) this;
		}
     public Criteria andTotalAmountNotBetween(Double value1, Double value2) {
		   addCriterion("total_amount not between", value1, value2, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountLike(Double value) {
		  addCriterion("total_amount like", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountNotLike(Double value) {
		  addCriterion("total_amount not like", value, "totalAmount");
		return (Criteria) this;
		}
 public Criteria andUserIdIsNull() {
		 addCriterion("user_id is null");
		return (Criteria) this;
		}
  public Criteria andUserIdIsNotNull(){
		addCriterion("user_id is not null");
		return (Criteria) this;
		}
  public Criteria andUserIdEqualTo(Integer value) {
		  addCriterion("user_id =", value, "userId");
		return (Criteria) this;
		}
   public Criteria andUserIdNotEqualTo(Integer value) {
		  addCriterion("user_id <>", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdGreaterThan(Integer value) {
		 addCriterion("user_id >", value, "userId");
		return (Criteria) this;
		}
  public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("user_id >=", value, "UserId");
		return (Criteria) this;
		}
   public Criteria andUserIdLessThan(Integer value) {
		  addCriterion("user_id <", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLessThanOrEqualTo(Integer value) {
		  addCriterion("user_id <=", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdIn(List<Integer> values) {
		  addCriterion("user_id in", values, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotIn(List<Integer> values) {
		  addCriterion("user_id not in", values, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdBetween(Integer value1, Integer value2) {
		   addCriterion("user_id between", value1, value2, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("user_id not between", value1, value2, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLike(Integer value) {
		  addCriterion("user_id like", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotLike(Integer value) {
		  addCriterion("user_id not like", value, "userId");
		return (Criteria) this;
		}
 public Criteria andOrderStatusIsNull() {
		 addCriterion("order_status is null");
		return (Criteria) this;
		}
  public Criteria andOrderStatusIsNotNull(){
		addCriterion("order_status is not null");
		return (Criteria) this;
		}
  public Criteria andOrderStatusEqualTo(Integer value) {
		  addCriterion("order_status =", value, "orderStatus");
		return (Criteria) this;
		}
   public Criteria andOrderStatusNotEqualTo(Integer value) {
		  addCriterion("order_status <>", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusGreaterThan(Integer value) {
		 addCriterion("order_status >", value, "orderStatus");
		return (Criteria) this;
		}
  public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("order_status >=", value, "OrderStatus");
		return (Criteria) this;
		}
   public Criteria andOrderStatusLessThan(Integer value) {
		  addCriterion("order_status <", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("order_status <=", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusIn(List<Integer> values) {
		  addCriterion("order_status in", values, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusNotIn(List<Integer> values) {
		  addCriterion("order_status not in", values, "orderStatus");
		return (Criteria) this;
		}
     public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
		   addCriterion("order_status between", value1, value2, "orderStatus");
		return (Criteria) this;
		}
     public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("order_status not between", value1, value2, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusLike(Integer value) {
		  addCriterion("order_status like", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusNotLike(Integer value) {
		  addCriterion("order_status not like", value, "orderStatus");
		return (Criteria) this;
		}
 public Criteria andCreateTimeIsNull() {
		 addCriterion("create_time is null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeIsNotNull(){
		addCriterion("create_time is not null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeEqualTo(String value) {
		  addCriterion("create_time =", value, "createTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeNotEqualTo(String value) {
		  addCriterion("create_time <>", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeGreaterThan(String value) {
		 addCriterion("create_time >", value, "createTime");
		return (Criteria) this;
		}
  public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("create_time >=", value, "CreateTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeLessThan(String value) {
		  addCriterion("create_time <", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLessThanOrEqualTo(String value) {
		  addCriterion("create_time <=", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeIn(List<String> values) {
		  addCriterion("create_time in", values, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotIn(List<String> values) {
		  addCriterion("create_time not in", values, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeBetween(String value1, String value2) {
		   addCriterion("create_time between", value1, value2, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeNotBetween(String value1, String value2) {
		   addCriterion("create_time not between", value1, value2, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLike(String value) {
		  addCriterion("create_time like", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotLike(String value) {
		  addCriterion("create_time not like", value, "createTime");
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
