// 예제 10-18 자바에서 어떻게 window()를 써서 윈도의 데이터를 집계하는가

JavaDStream<ApacheAccessLog> accessLogsWindow = accessLogsDStream.window(
    Durations.seconds(30), Durations.seconds(10));
JavaDStream<Integer> windowCounts = accessLogsWindow.count();
