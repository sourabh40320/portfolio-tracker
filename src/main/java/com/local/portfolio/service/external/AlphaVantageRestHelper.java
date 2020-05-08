//package com.local.portfolio.service.external;
//
//import com.local.portfolio.config.ApplicationConfig;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.conn.ssl.SSLSocketFactory;
//import org.apache.http.conn.ssl.X509HostnameVerifier;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.json.GsonJsonParser;
//import org.springframework.stereotype.Service;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import javax.net.ssl.*;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.Collections;
//
//@Service
//public class AlphaVantageRestHelper {
//
//    private Logger logger = LoggerFactory.getLogger(AlphaVantageRestHelper.class);
//
//    @Autowired
//    private ApplicationConfig applicationConfig;
//
//    public void getStockValue(String symbol) {
//
//        URI uri = null;
//        try {
//            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//            map.put("function", Collections.singletonList("TIME_SERIES_DAILY"));
//            map.put("symbol", Collections.singletonList(symbol));
////            map.put("apikey", Collections.singletonList(applicationConfig.getApiKey()));
////            UriComponents uriComponents = UriComponentsBuilder.fromUriString(applicationConfig.getGetStockValueUri())
////                    .queryParams(map).build();
////            uri = new URI(uriComponents.toUriString());
////        } catch (URISyntaxException e) {
////            e.printStackTrace();
////        }
//
//        HttpGet httpGet = new HttpGet();
//        httpGet.setURI(uri);
//
//        try {
//            HttpClient httpClient = wrapClient(new DefaultHttpClient());
//            HttpResponse response = httpClient.execute(httpGet);
//            if (response != null && response.getStatusLine().getStatusCode() == 200) {
//                GsonJsonParser gsonJsonParser = new GsonJsonParser();
//                gsonJsonParser.parseMap(response.getEntity().getContent().toString());
//            }
//        } catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
//            logger.error("error while fetching stock value ", e);
//        }
//    }
//
//    public static HttpClient wrapClient(HttpClient base) throws KeyManagementException, NoSuchAlgorithmException {
//        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
//        X509TrustManager tm = new X509TrustManager() {
//            public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
//            }
//            public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
//            }
//            public X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//        };
//        ctx.init(null, new TrustManager[]{tm}, null);
//        SSLSocketFactory ssf = new
//                SSLSocketFactory(ctx);
//        ssf.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//        ClientConnectionManager ccm = base.getConnectionManager();
//        SchemeRegistry sr = ccm.getSchemeRegistry();
//        sr.register(new Scheme("https", ssf, 443));
//        return new DefaultHttpClient(ccm, base.getParams());
//    }
//}
