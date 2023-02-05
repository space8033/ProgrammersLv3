import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class HotelReserve {
    public int solution(String[][] book_time) {
        int answer;
        List<Book> list = new ArrayList<>();

        for(String[] times : book_time) {
            int start = toMinute(times[0]);
            int end = toMinute(times[1]);

            list.add(new Book(start, end));
        }

        Collections.sort(list, ((o1, o2) -> {
            if(o1.start == o2.start) {

                return o1.end - o2.end;
            }else {

                return o1.start - o2.start;
            }
        }));

        List<Integer> endList = new ArrayList<>();

        for(Book book : list) {
            boolean isOk = false;
            Collections.sort(endList);

            for(int i = 0; i < endList.size(); i++) {
                int endTime = endList.get(i) + 10;

                if(book.start >= endTime) {
                    endList.set(i, book.end);
                    isOk = true;
                    break;
                }
            }

            if(!isOk) {
                endList.add(book.end);
            }
        }

        answer = endList.size();

        return answer;
    }

    public int toMinute(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        return hour * 60 + minute;
    }

    public class Book {
        int start;
        int end;

        public Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
