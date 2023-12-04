package com.room.model;
import java.util.ArrayList;
import java.util.List;
public class DeskInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public DeskInfoExample() {
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
 public Criteria andDeskNoIsNull() {
		 addCriterion("desk_no is null");
		return (Criteria) this;
		}
  public Criteria andDeskNoIsNotNull(){
		addCriterion("desk_no is not null");
		return (Criteria) this;
		}
  public Criteria andDeskNoEqualTo(String value) {
		  addCriterion("desk_no =", value, "deskNo");
		return (Criteria) this;
		}
   public Criteria andDeskNoNotEqualTo(String value) {
		  addCriterion("desk_no <>", value, "deskNo");
		return (Criteria) this;
		}
    public Criteria andDeskNoGreaterThan(String value) {
		 addCriterion("desk_no >", value, "deskNo");
		return (Criteria) this;
		}
  public Criteria andDeskNoGreaterThanOrEqualTo(String value) {
		  addCriterion("desk_no >=", value, "DeskNo");
		return (Criteria) this;
		}
   public Criteria andDeskNoLessThan(String value) {
		  addCriterion("desk_no <", value, "deskNo");
		return (Criteria) this;
		}
    public Criteria andDeskNoLessThanOrEqualTo(String value) {
		  addCriterion("desk_no <=", value, "deskNo");
		return (Criteria) this;
		}
    public Criteria andDeskNoIn(List<String> values) {
		  addCriterion("desk_no in", values, "deskNo");
		return (Criteria) this;
		}
    public Criteria andDeskNoNotIn(List<String> values) {
		  addCriterion("desk_no not in", values, "deskNo");
		return (Criteria) this;
		}
     public Criteria andDeskNoBetween(String value1, String value2) {
		   addCriterion("desk_no between", value1, value2, "deskNo");
		return (Criteria) this;
		}
     public Criteria andDeskNoNotBetween(String value1, String value2) {
		   addCriterion("desk_no not between", value1, value2, "deskNo");
		return (Criteria) this;
		}
    public Criteria andDeskNoLike(String value) {
		  addCriterion("desk_no like", value, "deskNo");
		return (Criteria) this;
		}
    public Criteria andDeskNoNotLike(String value) {
		  addCriterion("desk_no not like", value, "deskNo");
		return (Criteria) this;
		}
 public Criteria andDeskStatusIsNull() {
		 addCriterion("desk_status is null");
		return (Criteria) this;
		}
  public Criteria andDeskStatusIsNotNull(){
		addCriterion("desk_status is not null");
		return (Criteria) this;
		}
  public Criteria andDeskStatusEqualTo(Integer value) {
		  addCriterion("desk_status =", value, "deskStatus");
		return (Criteria) this;
		}
   public Criteria andDeskStatusNotEqualTo(Integer value) {
		  addCriterion("desk_status <>", value, "deskStatus");
		return (Criteria) this;
		}
    public Criteria andDeskStatusGreaterThan(Integer value) {
		 addCriterion("desk_status >", value, "deskStatus");
		return (Criteria) this;
		}
  public Criteria andDeskStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("desk_status >=", value, "DeskStatus");
		return (Criteria) this;
		}
   public Criteria andDeskStatusLessThan(Integer value) {
		  addCriterion("desk_status <", value, "deskStatus");
		return (Criteria) this;
		}
    public Criteria andDeskStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("desk_status <=", value, "deskStatus");
		return (Criteria) this;
		}
    public Criteria andDeskStatusIn(List<Integer> values) {
		  addCriterion("desk_status in", values, "deskStatus");
		return (Criteria) this;
		}
    public Criteria andDeskStatusNotIn(List<Integer> values) {
		  addCriterion("desk_status not in", values, "deskStatus");
		return (Criteria) this;
		}
     public Criteria andDeskStatusBetween(Integer value1, Integer value2) {
		   addCriterion("desk_status between", value1, value2, "deskStatus");
		return (Criteria) this;
		}
     public Criteria andDeskStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("desk_status not between", value1, value2, "deskStatus");
		return (Criteria) this;
		}
    public Criteria andDeskStatusLike(Integer value) {
		  addCriterion("desk_status like", value, "deskStatus");
		return (Criteria) this;
		}
    public Criteria andDeskStatusNotLike(Integer value) {
		  addCriterion("desk_status not like", value, "deskStatus");
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
