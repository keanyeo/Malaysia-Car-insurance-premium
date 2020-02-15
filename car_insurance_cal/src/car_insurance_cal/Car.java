package car_insurance_cal;

public class Car {
	
	public int cc;
	public int market_value;
	public int ncd;
	public int windscreen_cover;
	public int stamp=10;
	
	public Car(int cc,int market_value,int ncd,int windscreen_cover) {
		this.cc=cc;
		this.market_value=market_value;
		this.ncd=ncd;
		this.windscreen_cover=windscreen_cover;
		
	}
	
	public int getCC() {
		return cc;
	}
	
	public int getMarketValue() {
		return market_value;
	}
	
	public int getNCD() {
		return ncd;
	}
	
	public int getStamp() {
		return stamp;
	}
	
	public int getWindscreen_cover() {
		return windscreen_cover;
	}
	
	public double getRate() {
		cc=getCC();
		double rate = 0;
		if (cc<=1400) {
			rate=273.8;
		} else if (cc>1400 && cc<=1650) {
			rate=305.5;
		} else if (cc>1650 && cc<=2200) {
			rate=339.1;
		} else if (cc>2200 && cc<=3050) {
			rate=372.6;
		} else if (cc>3050 && cc<=4100) {
			rate=404.3;
		} else if (cc>4100 && cc<=4250) {
			rate=436;
		} else if (cc>4250 && cc<=4400) {
			rate=469.6;
		} else if (cc>4400) {
			rate=501.3;
		}
		return rate;
	}
	
	public double getRate2() {
		 market_value=getMarketValue();
		 int trate2=0;
		 trate2=(market_value-1000)/1000;
		 int rate2=trate2*26;
		 return rate2;
	}
	
	public double getBasicPrm() {
		double basicPrm=getRate()+getRate2();
		return basicPrm;
	}
	
	public double getNCDAMT() {
		int ncd=getNCD();
		double basicPrm = getBasicPrm();
		double ncd_amt=0;
		if (ncd==1) {
			ncd_amt=basicPrm*0.25;
		} else if (ncd==2) {
			ncd_amt=basicPrm*0.3;
		} else if (ncd==3) {
			ncd_amt=basicPrm*0.3833;
		} else if (ncd==4) {
			ncd_amt=basicPrm*0.45;
		} else if (ncd==5) {
			ncd_amt=basicPrm*0.55;
		} 
		return ncd_amt;
	}
	
	
	public double getWindscreen() {
		double wsamt=0;
		market_value=getMarketValue();
		windscreen_cover=getWindscreen_cover();
		
		if (windscreen_cover==1) {
		wsamt=market_value*0.0015;
		} else {
			wsamt=0;
		}
		return wsamt;
	}
	
	
	public double calGrsPrm() {
		double grs_prm;
		grs_prm = (getRate()+getRate2()-getNCDAMT()+getWindscreen());
		return grs_prm;
	}
	
	
	public double cal_pay_prm() {
		double pay_prm=0;
		pay_prm=calGrsPrm()+(calGrsPrm()*0.06)+getStamp();
		return pay_prm;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

