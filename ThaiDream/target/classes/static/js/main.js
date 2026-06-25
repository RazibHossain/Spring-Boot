$(document).ready(function () {

  // ── Mobile nav toggle ──
  $('#navToggle').on('click', function () {
    $('#navLinks').toggleClass('open');
  });

  // ── Navbar shrink on scroll ──
  $(window).on('scroll', function () {
    if ($(this).scrollTop() > 80) {
      $('.navbar').addClass('navbar-scrolled');
    } else {
      $('.navbar').removeClass('navbar-scrolled');
    }
  });

  // ── Scroll-reveal animations ──
  function revealOnScroll() {
    $('.package-card, .why-card, .dest-card, .testimonial-card, .free-card, .step').each(function () {
      var top = $(this).offset().top;
      var windowBottom = $(window).scrollTop() + $(window).height();
      if (top < windowBottom - 60) {
        $(this).addClass('visible');
      }
    });
  }
  $(window).on('scroll', revealOnScroll);
  revealOnScroll();

  // ── Booking form date minimum (today) ──
  var today = new Date().toISOString().split('T')[0];
  $('input[type="date"]').attr('min', today);

  // ── Contact form simulation ──
  $('#sendContactBtn').on('click', function () {
    var name = $(this).closest('.contact-form-wrap').find('input[type="text"]').val();
    var email = $(this).closest('.contact-form-wrap').find('input[type="email"]').val();
    var msg = $(this).closest('.contact-form-wrap').find('textarea').val();
    if (!name || !email || !msg) {
      alert('Please fill in all fields.');
      return;
    }
    $(this).text('Sending...').prop('disabled', true);
    setTimeout(function () {
      $('#contactSuccess').fadeIn();
      $('#sendContactBtn').text('Sent!');
    }, 1000);
  });

  // ── Smooth scroll hero arrow ──
  $('.hero-scroll').on('click', function () {
    $('html, body').animate({ scrollTop: $('.free-banner').offset().top }, 600);
  });

  // ── Package card hover glow (free) ──
  $('.free-package-card').on('mouseenter', function () {
    $(this).css('box-shadow', '0 12px 40px rgba(224,90,43,0.25)');
  }).on('mouseleave', function () {
    $(this).css('box-shadow', '');
  });

  // ── Booking page: update price estimate ──
  if ($('#bookingForm').length) {
    $('select[name="guests"]').on('change', function () {
      var guests = parseInt($(this).val()) || 1;
      var pricePerPerson = parseFloat($('.price-amt').first().text().replace('$', '').replace(',', '')) || 0;
      if (pricePerPerson > 0) {
        var total = guests * pricePerPerson;
        $('.price-amt').text('$' + total.toLocaleString());
      }
    });
  }
});
