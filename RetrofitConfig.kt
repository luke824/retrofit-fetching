/*

MIT License

Copyright (c) [2021] [Lukas Dagne]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/


import com.google.gson.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//region Build Retrofit

/**
 * Returns a `Retrofit` object configured with basic Json converter and http client.
 *
 * This configuration is adequate for most use cases. Apply any configuration change/s
 * in this `customBuild` function in order to support/apply corresponding unit-tests.
 */
fun Retrofit.Builder.customBuild(baseURL: String, callTimeoutInSeconds: Long = 10) : Retrofit {
    return this.baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
            .serializeNulls()
            .create())
        )
        .client(OkHttpClient.Builder()
            .callTimeout(callTimeoutInSeconds, TimeUnit.SECONDS)
            .build()
        )
        .build()
}

//endregion