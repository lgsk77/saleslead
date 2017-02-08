<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<head>

<jsp:include page="/WEB-INF/views/include/head.jsp" />
<jsp:include page="/WEB-INF/views/include/header.jsp" />
</head>
<body class="home">
	<section class="wrapper">
		<div class="slider-wrapper">
			<div class="slider">
				<div class="fs_loader"></div>
				<div class="slide">
					<img src="/saleslead/resources/images/fraction-slider/base_3.jpg"
						width="1920" height="auto" data-in="fade" data-out="fade" /> 
					<!-- <img src="/saleslead/resources/images/fraction-slider/slider-boy.png"
						width="550" height="450" data-position="30,1100" data-in="left"
						data-out="right" data-delay="700" /> -->
 
					<p class="slide-1" data-position="50,610" data-in="fade"
						data-out="fade" data-delay="800">잠재적인 고객의 요구와 행동을 미리 분석하고 예측하여</p>
					<p class="slide-1" data-position="100,500" data-in="fade"
						data-out="fade" data-delay="1200"> 고객이 원하는 맞춤형 제품과 서비스를 제공할 수 있게</p>
					<p class="slide-1" data-position="150,400" data-in="fade"
						data-out="fade" data-delay="1600">스마트한 인사이트를 제공합니다.</p>

					<p class="slide-1a" data-position="220,660" data-in="bottom"
						data-out="bottom" data-delay="2000" data-ease-in="easeOutBounce">고객을 확보하기 위해서는 고객을 각 개인으로 파악해야 합니다.</p>
					<p class="slide-1a" data-position="267,698" data-in="bottom"
						data-out="bottom" data-delay="3200" data-ease-in="easeOutBounce">SNS의 모든 데이터를 최대한으로 활용하여</p>
					<p class="slide-1a" data-position="314,760" data-in="bottom"
						data-out="bottom" data-delay="4200" data-ease-in="easeOutBounce">고객의 요구사항과 행동을 더욱 스마트하게 예측합니다.</p>
					<!-- <p class="slide-1a" data-position="361,753" data-in="bottom"
						data-out="bottom" data-delay="5200" data-ease-in="easeOutBounce"></p> -->
				</div>

				<div class="slide">
					<img src="/saleslead/resources/images/fraction-slider/base_2.jpg"
						width="1920" height="auto" data-in="fade" data-out="fade" /> <img
						src="/saleslead/resources/images/fraction-slider/2.PNG"
						width="800" height="450" data-position="20,400" data-in="right"
						data-0ut="bottom" data-delay="500" />

					<p class="slide-2 " data-position="120,1100" data-in="bottom"
						data-out="top" data-delay="2000">이제 시작하세요!</p>
					<p class="slide-2a " data-position="210,1100" data-in="left"
						data-out="right" data-delay="3000"> SNS 데이터 분석을 통한 마케팅 플랫폼</p>
					<p class="slide-2b " data-position="270,1100" data-in="top"
						data-out="bottom" data-delay="4000" data-ease-in="easeOutBounce">
						Sales_Lead</p>
				</div>
			</div>
		</div>
</section>
		<div class="container">
		<div style="height: 600px; padding-top: 70px; padding-bottom: 30px; margin: auto;">
		
			<div style="width: 250px; float :left">		
			<img src="/saleslead/resources/images/돈.jpg" >		
				<h1 style="text-align: center;">맞춤화</h1>
				<p style="text-align: center;">각 고객의 sns에서 </p>
				<p style="text-align: center;">이상항목을 발견한 후</p>
				<p style="text-align: center;">더욱 매력적이고 맞춤화된</p>
				<p style="text-align: center;">상품을 미리 제안합니다. </p>
			</div>
			<div style="width: 170px; float: left">&nbsp;</div>
			<div style="width: 250px; float :left">
			<img src="/saleslead/resources/images/폰차.jpg" >		
				<h1 style="text-align: center;">수익성</h1>
				<p style="text-align: center;">실시간으로 마케팅 자원을 최적화하고, </p>
				<p style="text-align: center;">표적화된 상향판매 및 교차판매</p>
				<p style="text-align: center;">상품을 제안할 수 있는 고급 연관 기법 </p>
				<p style="text-align: center;">고객의 고객생애가치를 높입니다.</p>
			</div>
			<div style="width: 170px; float: left">&nbsp;</div>
			<div style="width: 250px; float :left">
			<img src="/saleslead/resources/images/신뢰.jpg">		
				<h1 style="text-align: center;">고객확보</h1>
				<p style="text-align: center;">수익성 있는 고객을 바탕으로 한 </p>
				<p style="text-align: center;">세밀한 고객 분류를 통해  </p>
				<p style="text-align: center;">마케팅 효과를 .</p>
			</div>
		</div>
		</div>

		<div class="grey_bg pdt-70">
			<div class="container">
				<div class="row">
					<div class="col-sm-5 feature-block" >
						<img class="img-responsive center-block"
							src="/saleslead/resources/images/laptop.png" />
					</div>

					<div class="feature-block col-sm-7">
						<h4>
							가치가, 행복한 카풀 <span>함께 하는 카풀 서비스</span>
						</h4>
						<p>'가치가'는 고객들로 하여금 빠르고 안전하게 카풀을 찾을 수 있도록 하는
						도시 간 통근 차량 매칭 시스템 서비스를 제공하고 있습니다.
						서비스 이용객은 목적지와 여행 경로뿐만 아니라 성별, 일정 및 환경 설정에 따라 매치됩니다.
						'가치가'는 높은 연료 비용과 톨게이트 통행료 등에 따른 교통 비용을 절감하고 
						또한 불필요한 차량 운행을 줄여 운전자들로 하여금 스트레스를 줄이고 환경 보호 측면에도 도움을 제공합니다.
						'가치가' 이용 회원들은 통근 시간을 기록하고, 포인트를 쌓고, 콘테스트에 참여해 상을 받을 수 있습니다.
						'가치가'에 등록하여 나에게 가장 적합한 옵션을 찾아 보세요. 누구나 쉽고 간단하게 시작할 수 있습니다.
						회원 가입을 클릭하여 '가치가'에 지금 바로 등록하세요.</p>
						<a class="btn btn-default mrgb-20" href="">회원 가입</a>
					</div>
				</div>
			</div>
		</div>
	

	<!--start footer-->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-3 col-lg-3" style="width: 390px; float :left">
					<div class="widget_title">
						<h4>
							<span>가치가</span>
						</h4>
					</div>
					<div class="widget_content">
						<p>대표이사 :  <br /> 
						사업자 등록번호 : 12-345-890908 <br />
						주소 :  <br />
						개인정보관리책임자 :  <br />
						기술지원 :  <br />
						CS : <br />
						업무시간 : 평일 오전 8시~오후 5시(주말,공휴일 휴무) <br />
						Copyright © 2017-2017. All Rights Reserved.</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-3 col-lg-3" style="width: 390px; float :left">
					<div class="widget_title">
						<h4>
							<span>고객 만족</span>
						</h4>
					</div>
					<div class="widget_content">
						<p>가치가는 소망합니다. 럭시의 서비스가 여러분의 일상을 <br />
						조금이라도 더 행복하게 만들어 드릴 수 있기를..<br />
						그러기 위해 가치가는 계속 고민하고, 움직이며, <br />
						가치가만의 답을 만들어낼 것입니다.<br />
						이것이 가치가의 가장 큰 행복이고 비전입니다.</p>
						<ul class="contact-details-alt">
							<li><i class="fa fa-map-marker"></i>
								<p>
									<strong>Address</strong>: #2017
								</p></li>
							<li><i class="fa fa-user"></i>
								<p>
									<strong>Phone</strong>:(+82) 1234-5678
								</p></li>
							<li><i class="fa fa-envelope"></i>
								<p>
									<strong>Email</strong>: <a href="#">@example.com</a>
								</p></li>
						</ul>
					</div>
				</div>
			
				<div class="col-sm-6 col-md-3 col-lg-3" style="width: 390px; float :left">
					<div class="widget_title">
						<h4>
							<span>Gallery</span>
						</h4>
					</div>
					<div class="widget_content">
						<div class="flickr">
							<ul id="flickrFeed" class="flickr-feed"></ul>
						</div>
					</div>
				</div>
			</div>
			</div>
		
	</footer>
	<!--end footer-->

	<section class="footer_bottom">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<p class="copyright">
						&copy; Copyright 2016 Electrify | Powered by <a
							href="http://www.jqueryrain.com/">Together</a>
					</p>
				</div>

				<div class="col-sm-6 ">
					<div class="footer_social">
						<ul class="footbot_social">
							<li><a class="fb" href="#." data-placement="top"
								data-toggle="tooltip" title="Facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a class="twtr" href="#." data-placement="top"
								data-toggle="tooltip" title="Twitter"><i
									class="fa fa-twitter"></i></a></li>
							<li><a class="dribbble" href="#." data-placement="top"
								data-toggle="tooltip" title="Dribbble"><i
									class="fa fa-dribbble"></i></a></li>
							<li><a class="skype" href="#." data-placement="top"
								data-toggle="tooltip" title="Skype"><i class="fa fa-skype"></i></a></li>
							<li><a class="rss" href="#." data-placement="top"
								data-toggle="tooltip" title="RSS"><i class="fa fa-rss"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>