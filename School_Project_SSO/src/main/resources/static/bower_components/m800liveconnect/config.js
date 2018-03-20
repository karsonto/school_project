/* global $, liveConnect, domready */
var url = new Url(document.location.href);
/* testbed config */
var CONFIG = {
  url: 'https://cdn-tb.m800.hk/liveconnect/1.x/liveconnect.min.js',
  appKey: 'mapp41207121-3d73-5651-7e4d-567d7c3e6374',
  devKey: 'mdev49144ff7-d2bc-49d3-b5d3-8563a0fbb7df',
  appId: 'com.maaiii-api.org.offshore',
  carrierId: 'offshore.maaiii-api.org',
  version: '1.0.0',
  capabilities: ['incoming', 'outgoing'],
  serverConfig: {
    boshServer: {
      protocol: 'https',
      host: 'mbosh-tb.m800.com',
      port: 443,
    },
    sipServers: 'wss://webrtcgw.m800.com:8812',
  },
};
function overrideConfigFromQuery() {
  CONFIG.appKey = url.query.appKey || CONFIG.appKey;
  CONFIG.appId = url.query.appId || CONFIG.appId;
  CONFIG.devKey = url.query.devKey || CONFIG.devKey;
  CONFIG.carrierId = url.query.carrierId || CONFIG.carrierId;
  CONFIG.capabilities = (url.query.capabilities && url.query.capabilities.split(',')) || CONFIG.capabilities;
  CONFIG.version = url.query.version || CONFIG.version;
  CONFIG.serverConfig = CONFIG.serverConfig || {};
  CONFIG.serverConfig.boshServer = CONFIG.serverConfig.boshServer || {};
  CONFIG.serverConfig.boshServer.host = url.query.host || CONFIG.serverConfig.boshServer.host;
  CONFIG.serverConfig.boshServer.port = url.query.port || CONFIG.serverConfig.boshServer.port;
  CONFIG.serverConfig.boshServer.protocol = url.query.protocol || CONFIG.serverConfig.boshServer.protocol;
  CONFIG.serverConfig.sipServers = url.query.sipServers || CONFIG.serverConfig.sipServers;
}