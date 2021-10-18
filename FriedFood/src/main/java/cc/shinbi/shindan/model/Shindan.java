package cc.shinbi.shindan.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shindan {
	
	private List<Result>results;
	private List<Question>questions;
	
	private Shindan() {
		this.results = new ArrayList<Result>();
		this.questions = new ArrayList<Question>();
	}
	public List<Result>getResults(){
		return results;
	}
	public List<Question>getQuestions(){
		return questions;
	}
	public void shuffle() {
		for(Question question : this.questions) {
			question.shuffle();
		}
		Collections.shuffle(this.questions);
	}
	
	private static List<Result>getResultList(){
		Result[] results = {
				new Result("フライ","色々な食材が楽しめるフライです"),
				new Result("唐揚げ","味が濃い唐揚げです"),
				new Result("天ぷら","季節を味わえる天ぷらです"),
		};
		List<Result> list  = Arrays.asList(results);
		return list;
	}
	private static List<Question>getQuestionList(){
		List<Question>list = new ArrayList<Question>();
		
		Question question1 = new Question("q1","次の中で好きな食感は？");
		question1.addItem(0, "パリパリ");
		question1.addItem(1, "サクサク");
		question1.addItem(2, "カリッと");
		list.add(question1);
		
		Question question2 = new Question("q2","好きな食材は？");
		question2.addItem(0, "えびやさかななど");
		question2.addItem(1, "にく");
		question2.addItem(2, "やさい");
		list.add(question2);
		
		Question question3 = new Question("q3","食べ物に求めるのは？");
		question3.addItem(0, "強い香り");
		question3.addItem(1, "インパクトのある味");
		question3.addItem(2, "旬の食べ物");
		list.add(question3);
		
		Question question4 = new Question("q4","揚げ物につける調味料は？");
		question4.addItem(0, "ウスターソースなどのソース");
		question4.addItem(1, "何もつけない");
		question4.addItem(2, "塩");
		list.add(question4);
		
		Question question5 = new Question("q5","あなたならどの店に入る？");
		question5.addItem(0, "定食屋");
		question5.addItem(1, "ジャンクフード店");
		question5.addItem(2, "和食屋");
		list.add(question5);
		
		return list;
	}
	public static Shindan createShindan() {
		Shindan shindan = new Shindan();
		
		List<Result>results = getResultList();
		shindan.getResults().addAll(results);
		
		List<Question>question = getQuestionList();
		shindan.getQuestions().addAll(question);
		
		shindan.shuffle();
		
		return shindan;
	}
	public Result check(List<Integer>anwser) {
		int[]counters = new int [this.results.size()];
		Arrays.fill(counters, 0);
		
		for(Integer index:anwser) {
			counters[index]++;
		}
		int index = 0;
		int maxCount = 0;
		for(int i = 0;i<counters.length;i++) {
			int counter = counters[i];
			if(counter > maxCount) {
				index = i;
				maxCount = counter;
			}
		}
		return this.results.get(index);
	}
}
