/**
 * 객체 구조
 * {
 * path: url path,
 * view: *.vue 파일 이름
 * auth: true | false
 * }
 */
export default [{
    path: '/',
    view: 'HelloWorld'
},{
    path: '/test',
    view: 'Test'
},{ 
    // 상품상세페이지
    path: '/detail',
    view: 'Detail'
},{
    // 상품등록페이지
    path: '/insert',
    view: 'Insert'
}, {
    // 로그인페이지
    path: '/login',
    view: 'Login'
},{
    // 마이페이지 - 설정
    path: '/mypage/setting',
    view: 'Setting'
},{
    // 결제페이지
    path: '/pay',
    view: 'Pay'
},{
    // 회원가입
    path: '/signup',
    view: 'Signup'
},{
    // 마이페이지 - 내역
    path: '/mypage/history',
    view: 'History'
},{
    // 로그인 - 비밀번호찾기
    path: '/pwfind',
    view: 'PwFind'
},{
    // 로그인 - 아이디찾기
    path: '/idfind',
    view: 'IdFind'
},{
    // 상품 목록
    path: '/list',
    view: 'List'
},{
    // 에러페이지
    path: '/error',
    view: 'ErrorPage'
},{
    path: '/admin/sell-products',
    view: 'SellProducts'
}, {
    path: '/admin/sell-products/:id',
    view: 'SellProduct'
}]