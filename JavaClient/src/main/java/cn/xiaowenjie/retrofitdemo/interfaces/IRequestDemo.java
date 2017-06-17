package cn.xiaowenjie.retrofitdemo.interfaces;

import cn.xiaowenjie.retrofitdemo.beans.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface IRequestDemo {

	@GET("get1")
	Call<Result> get1();

	@GET("get2/{param1}")
	Call<Result> get2(@Path("param1") String str);

	@GET("get3")
	Call<Result> get3(@Query("param2") String str);

	@Headers({ "Authorization: Basic ====------",
		"User-Agent: Retrofit-Sample-App" })
	@GET("headtest")
	Call<Result> headtest();
}
