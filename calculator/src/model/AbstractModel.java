package model;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractModel implements Model {

	private ArrayList listeners = new ArrayList(5);
	
	public void notifyChanged(ModelEvent event){

		ArrayList list = (ArrayList)listeners.clone();
		for (Object o : list) {
			ModelListener ml = (ModelListener) o;
			ml.modelChanged(event);
		}
	}
	public void addModelListener(ModelListener l){

		listeners.add(l);
	}

	public void removeModelListener(ModelListener l){

		listeners.remove(l);
	}
}
