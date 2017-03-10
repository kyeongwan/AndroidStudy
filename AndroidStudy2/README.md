## 2. Intent

```
Intent i = new Intent(); // 인덴트 선언
i.setClass(getApplicationContext(), NextActivity.class);// 만든 인덴트에다가 클래스 선언해줌 context, ClassName
i.putExtra("Data", num);// putExtra(key value) 인덴트에다가 데이터를 실어 보낼때
startActivityForResult(i, 100);// 보통은 startActivity(intent) , startActivityForResult(intent, reqcode) 다시 이 액티비티가 호출되었을 때
// onActivityResult() 를 호출합니다
```
이렇게 선언하는 방법도 있음 
```
Intent i = new Intent(getApplicationContext(), NextActivity.class);
startActivity(i);
```

결과값을 리턴 받기 위해서는 
``` startActivityForResult(Intent, Int reqCode)```
를 사용한다.


---
### Log
```
static int Log.d (String tag, String msg [, Throwable tr]) d 는 debug 의 약자로 debug 용 로그입니다. DDMS Logcat 상에는 검정색 파란색으로 출력됩니다.
static int Log.e (String tag, String msg [, Throwable tr]) e 는 error 의 약자로 error 용 로그입니다. 보통 exception 이 발생하거나 Error 가 발생할 경우 system이 이녀석을 활용합니다. 색깔은 빨간색입니다.
static int Log.w (String tag, String msg [, Throwable tr]) w 는 warning 의 약자로 경고를 표시합니다. 보통 exception 이 발생했을 때 자주 쓰입니다. ( error 와 구분. ) 색깔은 주황색입니다.
static int Log.i (String tag, String msg [, Throwable tr]) i 는 information 의 약자로 일반 정보를 표시할 때 사용됩니다. 색깔은 초록색입니다.
static int Log.v (String tag, String msg [, Throwable tr]) v 는 verbose 의 약자로, 색깔은 검은색. 개발중에만 나타내는 용도의 로그입니다.
```


---
###Activity Life Cycle

![Activity Life Cycle](https://developer.android.com/images/training/basics/basic-lifecycle-create.png?hl=ko)

