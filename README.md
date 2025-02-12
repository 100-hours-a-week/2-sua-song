☕️스타벅스에서 커피랑 디저트 주문하기☕️

스타벅스에 어서오세요!
스타벅스에서 음료를 고르고, 디저트를 구매할 수 있습니다?!
그리고 맴버십 할인도 받아봐요


🐼시나리오
1. 시스템이 “스타벅스” 소개와 메인 메뉴를 디스플레이한다.
2. 사용자가 원하는 음료 메뉴를 선택해서 입력한다.
	2-1. 주어진 번호 외로 입력시 [error] 메세지가 표출된다.
3. 시스템이 디저트 메뉴를 디스플레이한다.
4. 사용자가 원하는 디저트 메뉴를 선택해서 입력한다.
	4-1. 주어진 번호 외로 입력시 [error] 메시지가 표출된다.
5. 사용자가 맴버십 여부 입력한다.
	5-1. 멤버십 등급은 "Basic", "Gold" , "Vip" 순으로 각각 할인율이 적용되어 있다!
6. 사용자가 안내받은 총 지불금액을 확인하고 결제할 금액 입력한다.
	6-1. 지불한 금액이 결제금액보다 낮을 경우 [error] 메시지가 표출된다.
	6-2. 문자로 입력될 경우 [error] 메시지가 표출된다.
8. 잔돈을 받는다.
9. 추가로 주문을 할지 안할지 묻습니다
10. 주문을 완료한 경우 바리스타가 제조를 시작합니다.
11. 바리스타가 제조시간에 따라 주문을 완료하면 제조 완료! 라고 뜹니다


****
비동기 서비스로 주문 넣는 것을 추가하였습니다.
음료를 제조하는 것에 걸리는 시간을 추가하여, 걸리는 시간이 적은 순대로 주문이 완료되면
”✅ 주문이 완료되었습니다! 바리스타가 음료를 제조 중입니다…” 라고 메세지가 나옵니다
음료 제작이 끝나면
”☕ 바리스타: " + order.getItemName() + " 제조 완료!” 라고 메세지가 나옵니다

