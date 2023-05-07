import se.lth.cs.pt.window.SimpleWindow;

public class SimpleWindowExample {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");

		w.moveTo(400, 400);
		w.lineTo(400, 100);
		w.moveTo(100, 400);
		w.lineTo(100, 100);
		w.moveTo(100, 100);
		w.lineTo(400, 100);
		w.moveTo(100, 400);
		w.lineTo(400, 400);
		w.moveTo(350, 400);
		w.lineTo(350, 300);
		w.moveTo(300, 400);
		w.lineTo(300, 300);
		w.moveTo(350, 300);
		w.lineTo(300, 300);

	}

}
