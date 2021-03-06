# exchange-rate
환율꼐산을 위한 웹 프로젝트

## 기능 명세서
 - 송금국가와 통화를 가진다.
    - 송금국가는 미국으로 고정한다.
    - 통화는 미국달러(USD)이다.
 - 수취국가를 입력받는다. 
    - 수취국가는 한국, 일본, 필리핀 세 군데 중 하나를 select box로 입력받는다.
    - 각각 통화는 KRW, JPY, PHP이다.
 - 수취금액을 입력받는다.
    - 수취 금액을 입력하지 않거나, 0보다 작은 금액이거나 10,000 USD보다 큰 금액, 혹은 바른 숫자가 아니라면 
    "송금액이 바르지 않습니다"라는 에러 메시지를 보여준다.
    - 메시는 팝업, 혹은 하단에 빨간 글씨로 나타내면 된다. 
 - 수취국가를 선택하면 환율이 바뀌어서 나타난다.
    - 환율은 1 USD 기준으로 각각 KRW, JPY, PHP 대응 금액이다.
 - 송금액을 USD로 입력하고 Submit하면 수취금액이 KRW, JPY, PHP 중 하나로 계산되어서 나와야 한다.
 - 환율과 수취금액은 소수점 2째자리까지, 3자리 이상 되면 콤마를 가운데 찍어 보여준다.(예 - 1234 -> 1,2345.00)
 - 환율정보는 https://currencylayer.com/를 이용한다.
 - 수취국가를 변경할 때마다 환율정보를 가져와 전달한다.

## 개발 환경
 - Spring Boot(2.4.3), Java(11)
 - thymeleaf, Javascript
 - Junit5
 
## 개발 목표
 - TDD를 기반으로 개발한다.
 - 다음과 같은 객체지향 생활 체조원칙 9가지를 지키며 개발한다.
```text
  규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
  규칙 2: else 예약어를 쓰지 않는다.
  규칙 3: 모든 원시값과 문자열을 포장한다.
  규칙 4: 한 줄에 점을 하나만 찍는다.
  규칙 5: 줄여쓰지 않는다(축약 금지).
  규칙 6: 모든 엔티티를 작게 유지한다.
  규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
  규칙 8: 일급 콜렉션을 쓴다.
  규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.
```

## Conventions
 - git commit message
    - https://udacity.github.io/git-styleguide/
 - code  
    - 원문 : https://www.oracle.com/java/technologies/javase/codeconventions-contents.html
    - 번역 : https://myeonguni.tistory.com/1596
