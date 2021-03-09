/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.data;

import java.util.List;
import java.util.Objects;

/**
 * Converter for {@link ShadowArrayData} of external type.
 */
public class ShadowArrayData<T> implements ArrayData {

	public final List<T> data;

	public ShadowArrayData(List<T> list) {
		Objects.requireNonNull(list);
		this.data = list;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isNullAt(int pos) {
		return data.size() <= pos || data.get(pos) == null;
	}

	@Override
	public boolean getBoolean(int pos) {
		return (boolean) getObject(pos);
	}

	@Override
	public byte getByte(int pos) {
		return (byte) getObject(pos);
	}

	@Override
	public short getShort(int pos) {
		return (short) getObject(pos);
	}

	@Override
	public int getInt(int pos) {
		return (int) getObject(pos);
	}

	@Override
	public long getLong(int pos) {
		return (long) getObject(pos);
	}

	@Override
	public float getFloat(int pos) {
		return (float) getObject(pos);
	}

	@Override
	public double getDouble(int pos) {
		return (double) getObject(pos);
	}

	@Override
	public StringData getString(int pos) {
		return (StringData) getObject(pos);
	}

	@Override
	public DecimalData getDecimal(int pos, int precision, int scale) {
		return (DecimalData) getObject(pos);
	}

	@Override
	public TimestampData getTimestamp(int pos, int precision) {
		return (TimestampData) getObject(pos);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <U> RawValueData<U> getRawValue(int pos) {
		return (RawValueData<U>) getObject(pos);
	}

	@Override
	public byte[] getBinary(int pos) {
		return (byte[]) getObject(pos);
	}

	@Override
	public ArrayData getArray(int pos) {
		return (ArrayData) getObject(pos);
	}

	@Override
	public MapData getMap(int pos) {
		return (MapData) getObject(pos);
	}

	@Override
	public RowData getRow(int pos, int numFields) {
		return (RowData) getObject(pos);
	}

	@Override
	public boolean[] toBooleanArray() {
		int numElements = data.size();
		boolean[] res = new boolean[numElements];
		for (int i = 0; i < numElements; i++) {
			res[i] = getBoolean(i);
		}
		return res;
	}

	@Override
	public byte[] toByteArray() {
		int numElements = data.size();
		byte[] res = new byte[numElements];
		for (int i = 0; i < numElements; i++) {
			res[i] = getByte(i);
		}
		return res;
	}

	@Override
	public short[] toShortArray() {
		int numElements = data.size();
		short[] res = new short[numElements];
		for (int i = 0; i < numElements; i++) {
			res[i] = getShort(i);
		}
		return res;
	}

	@Override
	public int[] toIntArray() {
		int numElements = data.size();
		int[] res = new int[numElements];
		for (int i = 0; i < numElements; i++) {
			res[i] = getInt(i);
		}
		return res;
	}

	@Override
	public long[] toLongArray() {
		int numElements = data.size();
		long[] res = new long[numElements];
		for (int i = 0; i < numElements; i++) {
			res[i] = getLong(i);
		}
		return res;
	}

	@Override
	public float[] toFloatArray() {
		int numElements = data.size();
		float[] res = new float[numElements];
		for (int i = 0; i < numElements; i++) {
			res[i] = getFloat(i);
		}
		return res;
	}

	@Override
	public double[] toDoubleArray() {
		int numElements = data.size();
		double[] res = new double[numElements];
		for (int i = 0; i < numElements; i++) {
			res[i] = getDouble(i);
		}
		return res;
	}

	private Object getObject(int pos) {
		throw new UnsupportedOperationException("ShadowArrayData don't support get operation");
	}
}
