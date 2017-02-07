package cn.xiaowenjie.retrofitdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cn.xiaowenjie.retrofitdemo.interfaces.IRequestDemo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SpringBootApplication
public class RetrofitDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrofitDemoApplication.class, args);
	}

	@Bean
	public IRequestDemo getIRequestDemo() {
		System.out.println("RetrofitDemoApplication.getIRequestDemo()");
		
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://127.0.0.1:8081/demo/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		
		IRequestDemo service = retrofit.create(IRequestDemo.class);
		
		return service;
	}
}
