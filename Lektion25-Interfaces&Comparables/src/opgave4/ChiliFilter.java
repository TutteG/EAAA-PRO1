package opgave4;

public class ChiliFilter implements Filter {
	public ChiliFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(Measurable x) {
		// TODO Auto-generated method stub
		if (x.getMeasure() >= 10000) {
			return true;
		} else {
			return false;
		}
	}

}
