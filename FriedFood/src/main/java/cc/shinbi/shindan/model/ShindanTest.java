package cc.shinbi.shindan.model;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ShindanTest {

	@Test
	void test() {
		Shindan shindan = Shindan.createShindan();
		for(Question question:shindan.getQuestions()) {
			System.out.println(question.getQuestion());
			for(Item item:question.getItems()) {
				System.out.println(String.format(
						" %d-%s",
						item.getId(),
						item.getText()
						)
					);
			}
		}
		System.out.println("");
		List<Integer>list  = Arrays.asList(0,1,2);
		Result result = shindan.check(list);
		System.out.println(list);
		System.out.println(result.getName());
		System.out.println(result.getDescription());
	}
}
