<#macro slider>
<div id="carousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carousel" data-slide-to="0" class="active"></li>
        <li data-target="#carousel" data-slide-to="1"></li>
        <li data-target="#carousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner rounded">
        <div class="carousel-item active ">
            <img class="d-block w-100"
                 src="https://st.depositphotos.com/1003700/2175/i/450/depositphotos_21752331-stock-photo-colorful-leather-shoes.jpg"
                 alt="Первый слайд">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://lh3.googleusercontent.com/proxy/0hhsr5jKeMujrstestamjfdxGtO2DULVRgPeUTyNpucc-sL5TTiEfdlRbSZ97yyKK1zmFvWb6LjDbm3gCG3awSNq11Xj1oweHaaIMp1zqCTm6LpGWUcQojCEVwAGZpeM"
                 alt="Второй слайд">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://cdn.freelance.ru/download/941427/%E11.jpg"
                 alt="Третий слайд">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<style>img{height: 400px; object-fit: cover;}</style>
</#macro>