# AppFriends Android Sample App
This sample app is created by AppFriends to demo AppFriends Android SDK.

## Gradle Integration
```
repositories {
    maven { url 'https://raw.githubusercontent.com/Hacknocraft/AppFriendsAndroidCore/master/' }
}

dependencies {
    // AppFriends
    compile 'me.appfriends.sdk:ui:3.0.3'
}
```

## Setting App Key and App Secret
In `AndroidManifest.xml` file, please specify your App Key and App Secret:
```
<meta-data
    android:name="me.appfriends.AppID"
    android:value="[your app id here]" />

<meta-data
    android:name="me.appfriends.AppSecret"
    android:value="[your app secret here]" />
```

## Login user
Please login to AppFriends before start using the SDK.
```
AppFriends.getInstance().login("user_id", "user_name")
                            .subscribe(new Subscriber<Boolean>() {
                                @Override
                                public void onCompleted() {
                                }

                                @Override
                                public void onError(Throwable e) {
                                    // handle name
                                }

                                @Override
                                public void onNext(Boolean loggedIn) {
                                    // success
                                }
                            });
  ```

