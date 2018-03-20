window.lcwcSettings = CONFIG;
window.lcwcAsyncInitSuccess = function(LC) {
  LC.contentWindow.__lcwc__mockTagsMap = [
    {
      tagRegex: '.*web.*',
      urlRegex: '.*about-us.*',
    },
    {
      tagRegex: '.*fung.*$',
      urlRegex: '.*company.*',
    },
  ];

  const inquiryMetadataHandler = function getInquiryMetadataAsync(tagId, lang) {
    return new Promise(function (resolve) {
      setTimeout(function () {
        resolve([
          {
            k: 'tagId',
            v: tagId,
          },
          {
            k: 'lang',
            v: lang,
          },
          {
            k: 'customerId',
            v: 'A123456',
          },
          {
            k: 'isPremium',
            v: false,
          },
          {
            k: 'balance',
            v: 1000,
          },
          {
            k: 'crmTagSecret',
            v: 'afs1241safa',
            h: true,
          },
        ]);
      }, 1000); // set delay to simulate aync loading
    });
  };

  LC.setInquiryMetadataHandler(inquiryMetadataHandler, 8000);
};

!function(e,t,c){var n,s=e.getElementsByTagName(t)[0];e.getElementById(c)||(n=e.createElement(t),n.id=c,n.async=!0,n.src=CONFIG.url,s.parentNode.insertBefore(n,s))}(document,"script","lcwc-sdk");