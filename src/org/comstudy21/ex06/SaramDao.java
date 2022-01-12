package org.comstudy21.ex06;

import java.util.Vector;

public class SaramDao {
	private static Vector<SaramDTO> saramList = new Vector<SaramDTO>();
	static {
		saramList.add(new SaramDTO(1, "kim", "kim@aa.com", "010-1111-1111"));
		saramList.add(new SaramDTO(2, "lee", "lee@aa.com", "010-2222-2222"));
		saramList.add(new SaramDTO(3, "park", "park@aa.com", "010-3333-3333"));
	}
	public static int sequence = 4;
	
	public Vector selectAll() {
		Vector vector = new Vector();
		for(int i=0; i<saramList.size(); i++) {
			vector.add(saramList.get(i).toVector()); // 테이블모델이 해당 데이터를 알기 위해서
		}
		return vector;
	}

	public void insert(SaramDTO saramDto) {
		if(saramDto != null) {
			saramDto.setIdx(sequence++);
			saramList.add(saramDto);
		}
	}

	public Vector search(SaramDTO saramDto) {
		Vector vector = new Vector();
		for(int i=0; i<saramList.size(); i++) {
			if(saramDto.getName().equals(saramList.get(i).getName())) {
				vector = saramList.get(i).toVector();
				return vector;	
			}
		}
		return null;
	}

	public Vector modify(SaramDTO saramDto) {
		Vector vector = new Vector();		
		int index = 0;
		for(int i = 0; i<saramList.size(); i++) {
			if(saramDto.getIdx() == saramList.get(i).getIdx()) {
				index = i;
				saramList.set(index, saramDto);
			}
		}
		vector = saramList.get(index).toVector();
		return vector;
	}

	public Vector delete(SaramDTO saramDto) {
		Vector vector = new Vector();		
		int index = 0;
		for(int i = 0; i<saramList.size(); i++) {
			if(saramDto.getIdx() == saramList.get(i).getIdx()) {
				index = i;
				saramList.remove(index);
			}
		}
		vector = saramList.get(index).toVector();
		return vector;
	}


}
