# jpa_test  
    
출처 : https://gmlwjd9405.github.io/2018/12/25/difference-jdbc-jpa-mybatis.html  
    
### ORM(Object-Relational Mapping) vs SQL mapper  
· ORM은 데이터베이스 객체를 자바 객체로 매핑함으로써 객체 간의 관계를 바탕으로 SQL을 자동으로 생성해주지만  
&nbsp;&nbsp; SQL Mapper는 SQL을 명시해줘야 한다.  
  
· ORM은 관계형 데이터베이스의 ‘관계’를 Object에 반영하자는 것이 목적  
&nbsp;&nbsp; SQL Mapper는 단순히 필드를 매핑시키는 것이 목적  
  
<br/>
<br/>

### JPA  
· 자바 ORM 기술에 대한 API 표준 명세로, Java에서 제공하는 API  
  
· JPA 구성요소 4가지  
&nbsp;&nbsp; 1)javax.persistance 패키지로 정의된 API 그 자체  
&nbsp;&nbsp; 2) JPQL(Java Persistence Query Language)  
&nbsp;&nbsp; 3) 객체/관계 메타데이터  

<br/>
<br/>

### Hibernate
· JPA의 구현체 중 하나  
  
· HQL, criteria 사용  
· 로그인 같은 검증 기능 제공  
  
· 장점  
&nbsp;&nbsp; 1) 객체지향적으로 데이터를 관리할 수 있기 때문에 비즈니스 로직에 집중할 수 있다.  
&nbsp;&nbsp; 2) 테이블 생성, 변경, 관리가 쉽다.  
&nbsp;&nbsp; 3) 로직을 쿼리에 집중하기 보다는 객체 자체에 집중 할 수 있다.  
&nbsp;&nbsp; 4) 빠른 개발이 가능하다.  
&nbsp;&nbsp; 5) ehcache 전략을 사용(많이 사용하는 데이터를 따로 저장해서 접근 속도 향상 시키는 캐시 전략)  
  
· 단점  
&nbsp;&nbsp; 1) 어렵다.  
&nbsp;&nbsp; 2) 잘 이해하지 않으면 데이터 손실이 있을 수 있다.  
&nbsp;&nbsp; 3) 성능상 문제가 있을 수 있다.  

<br/>
<br/>

### JPQL  
· 엔티티는 db의 테이블 이름이 아닌 자바단에서의 엔티티 이름  
· 별칭은 무조건 사용해야함, as는 생략 가능
