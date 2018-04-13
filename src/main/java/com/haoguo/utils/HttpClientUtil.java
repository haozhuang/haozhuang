package com.haoguo.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author lixia
 * @since 2017年4月11日下午4:26:50
 * @description httpClientUtil
 */
public class HttpClientUtil {

	public static String doGet(String url, Map<String, String> param) {

		// 创建HttpClient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建 http Get请求
			HttpGet httpGet = new HttpGet(uri);
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			int statusCode = 200;
			if (response.getStatusLine().getStatusCode() == statusCode) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url, Map<String, String> param, Map<String, String> cookie) {
		// 创建HttpClient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建 http Get请求
			HttpGet httpGet = new HttpGet(uri);
			// 拼接cookie
			if (cookie != null) {
				StringBuilder cookieStr = new StringBuilder();
				for (Entry<String, String> entry : cookie.entrySet()) {
					cookieStr.append(entry.getKey()).append("=").append(entry.getValue());
				}
				httpGet.setHeader("Cookie", cookieStr.toString());
			}
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			int statusCode = 200;
			if (response.getStatusLine().getStatusCode() == statusCode) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param) {
		// 创建HttpClient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "UTF-8");
				httpPost.setEntity(entity);
			}
			response = httpclient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String postHttp(String json, String url) throws Exception {
		// 第一步：创建一个httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 第二步：创建一个HttpPost对象。需要指定一个url
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/json;charset=utf-8");
		RequestConfig config = RequestConfig.custom().setConnectTimeout(50000).setConnectionRequestTimeout(10000)
				.setSocketTimeout(50000).build();
		post.setConfig(config);
		// 第四步：需要把表单包装到Entity对象中。StringEntity
		StringEntity entity = new StringEntity(json, "utf-8");
		post.setEntity(entity);
		// 第五步：执行请求。
		CloseableHttpResponse response = httpClient.execute(post);
		// 第六步：接收返回结果
		HttpEntity httpEntity = response.getEntity();
		String result = EntityUtils.toString(httpEntity);
		// 第七步：关闭流。
		response.close();
		httpClient.close();
		return result;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}

	public static String doPostJson(String url, String json) {
		// 创建HttpClient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpclient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static void updateConfig(String newCfgPath, String din, HashMap<String, String> map, String localUrl) {

		String read = read(localUrl, map);
		write(newCfgPath, read, din);
	}

	/**
	 * 读取文件内容
	 * 
	 * @param filePath
	 * @return
	 */
	public static String read(String filePath, HashMap<String, String> map) {
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		String str2 = null;
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));

			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
				// 此处根据实际需要修改某些行的内容
				if (line.contains("CameraRtsp=rtsp:")) {
					String[] sp1 = line.split("//");
					System.out.println(sp1[1]);
					if (sp1[1].contains("username")) {
						String[] sp2 = sp1[1].split(":");
						// if(sp2[1].contains("username")){
						if (sp1[0].contains("1")) {
							str2 = sp1[0] + map.get("in") + ":" + sp2[1];
						}
						if (sp1[0].contains("2")) {
							str2 = sp1[0] + map.get("out") + ":" + sp2[1];
						}

						// }
					}
					System.out.println(str2);
					buf.append(str2);
				}
				// 如果不用修改, 则按原来的内容回写
				else {
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
				}
			}
		}

		return buf.toString();
	}

	/**
	 * 将内容回写到文件中
	 * 
	 * @param filePath
	 * @param content
	 */
	public static void write(String filePath, String content, String din) {
		BufferedWriter bw = null;

		try {
			// 根据文件路径创建缓冲输出流
			bw = new BufferedWriter(new FileWriter(filePath + File.separator + din));
			// 将内容写入文件中
			bw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					bw = null;
				}
			}
		}
	}

	public static String downloadConfig(String cfgPath, String url, String din) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File(cfgPath);
		try {
			urlfile = new URL(url);
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f.getPath() + File.separator + din));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
			return f.getPath() + File.separator + din;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
