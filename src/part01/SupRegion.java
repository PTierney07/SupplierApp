package part01;

public enum SupRegion {

	UNITED_KINGDOM {
		@Override
		String getSupRegionAsString() {
			// TODO Auto-generated method stub
			return "United Kingdom";
		}
	},EUROPE {
		@Override
		String getSupRegionAsString() {
			// TODO Auto-generated method stub
			return "Europe";
		}
	},OUTSIDE_EU {
		@Override
		String getSupRegionAsString() {
			// TODO Auto-generated method stub
			return "Outside EU";
		}
	};
	
	abstract String getSupRegionAsString();
}
