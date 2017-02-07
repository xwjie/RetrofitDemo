package cn.xiaowenjie.retrofitdemo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xiaowenjie.retrofitdemo.beans.Result;
import cn.xiaowenjie.retrofitdemo.interfaces.IRequestDemo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrofitDemoApplicationTests {

	@Autowired
	IRequestDemo demo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void synTest() throws IOException {
		System.out.println("------------同步调用测试----------");

		Call<Result> result1 = demo.get1();
		System.out.println("同步调用测试1 " + result1.execute().body());

		Call<Result> result2 = demo.get2("参数1");
		System.out.println("同步调用测试2 " + result2.execute().body());

		Call<Result> result3 = demo.get3("参数2");
		System.out.println("同步调用测试3 " + result3.execute().body());

		System.out.println("------------同步调用测试结束----------\n\n");
	}

	@Test
	public void asynTest() throws IOException {
		System.out.println("------------异步调用测试----------");

		Call<Result> result1 = demo.get1();
		result1.enqueue(new Callback<Result>() {

			@Override
			public void onResponse(Call<Result> call, Response<Result> response) {
				System.out.println("异步调用测试1 " + response.body());
			}

			@Override
			public void onFailure(Call<Result> call, Throwable e) {
				System.err.println(e.toString());
			}
		});

		Call<Result> result2 = demo.get2("参数1");
		result2.enqueue(new Callback<Result>() {

			@Override
			public void onResponse(Call<Result> call, Response<Result> response) {
				System.out.println("异步调用测试3 " + response.body());
			}

			@Override
			public void onFailure(Call<Result> call, Throwable e) {
				System.err.println(e.toString());
			}
		});

		Call<Result> result3 = demo.get3("参数2");
		result3.enqueue(new Callback<Result>() {

			@Override
			public void onResponse(Call<Result> call, Response<Result> response) {
				System.out.println("异步调用测试3 " + response.body());
			}

			@Override
			public void onFailure(Call<Result> call, Throwable e) {
				System.err.println(e.toString());
			}
		});

		System.out.println("------------异步调用测试结束----------\n\n");
	}

	@Test
	public void headerTest() throws IOException {
		System.out.println("-----------请求里面带header测试----------");

		Call<Result> result1 = demo.headtest();
		System.out.println("请求里面带header测试 " + result1.execute().body());
	}
}
