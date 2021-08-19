package project;

import java.util.Arrays;

public class Memory {
	public static final int DATA_SIZE = 512;
	private static int[] data = new int[DATA_SIZE];
	private int changedDataIndex = -1; // used in GUI
	
	public int getData(int index) throws DataAccessException {
		if (index < 0 || index >= DATA_SIZE) {
			throw new DataAccessException("illegal index " + index);
		}
		return data[index];
	}
	
	// throws are not required (unchecked/runtime exception)
	public void setData(int index, int value) throws DataAccessException {
		if (index < 0 || index >= DATA_SIZE) {
			throw new DataAccessException("illegal index " + index);
		}
		data[index] = value;
		changedDataIndex = index;
	}
	
	// throws are not required (unchecked/runtime exception)
	public int[] getDataRange(int min, int max) throws DataAccessException{
		if (min <= 0 || max >= DATA_SIZE || min > max) {
			throw new DataAccessException("illegal indices " + min + " " + max);
		}
		return Arrays.copyOfRange(data, min, max);
	}
	
	public int[] getDataArray() {
		return data;
	}

	public int getChangedDataIndex() {
		return changedDataIndex;
	}
	
	public void clearData() {
		for (int i = 0; i < data.length; ++i) {
			data[i] = 0;
		}
		changedDataIndex = -1;
	}
}
