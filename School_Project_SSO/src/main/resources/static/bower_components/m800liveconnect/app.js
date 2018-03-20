var pages = [
  {
    name: 'Home',
    id: 'index',
  },
  {
    name: 'About-us (S. Chinese)',
    id: 'about-us',
  },
  {
    name: 'Company (T. Chinese)',
    id: 'company',
  },
  {
    name: 'Staff (Thai)',
    id: 'staff',
  },
];

// Enable everything logged to `debug`.
// !! This must be set before loading the actual app!!
localStorage.setItem('debug', '*');


domready(function () {
  // setup navigation
  var $ul = $('<ul>');

  pages.forEach(function (page) {
    $ul.append($('<li>').html('<a href="./' + page.id + '.html?'  + '">' + page.name + '</a>'));
  });

  $('#menu').append($ul);

  // allow config throw url query params
  
});