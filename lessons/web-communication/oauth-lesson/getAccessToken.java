private void getAccessToken(String code){
        Log.d(LoginActivity.class.getName(),"Trying to get access token");
        final OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("client_secret", InstagramAppData.CLIENT_SECRET)
                .add("client_id",InstagramAppData.CLIENT_ID)
                .add("grant_type","authorization_code")
                .add("redirect_uri", InstagramAppData.CALLBACK_URL)
                .add("code",code)
                .build();

        Request request = new Request.Builder()
                .url("https://api.instagram.com/oauth/access_token")
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                String responseBody = response.body().string();
                Log.d(LoginActivity.class.getName(),responseBody);
                try {
                    JSONObject result = new JSONObject(responseBody);
                    JSONObject user = result.getJSONObject("user");

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("accessToken",result.getString("access_token"));
                    intent.putExtra("userId",user.getString("id"));
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
