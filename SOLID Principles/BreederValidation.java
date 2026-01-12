package com.mopokens.battle;
import java.util.*;
public class BreederValidation {
	 public void validate(Breeder breeder) {
		List<Mopoken> mopokens=breeder.getMopokens();
		
		if(mopokens.size()!=5) {
			throw new IllegalArgumentException("Each  breeder must have 5 mopokens to participate in battle");
		}
		Set<String> types=new TreeSet<String>();
		for(Mopoken m:mopokens) {
			if(!types.add(m.getMopokenType())) {
				throw new IllegalArgumentException("you should have unique mopokens");
			}
		}
	}
}
