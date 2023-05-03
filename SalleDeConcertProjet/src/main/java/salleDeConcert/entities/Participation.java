package model;

import java.util.List;

public class Participation {
	private Reservation reservation;
	private Participant participant;
	
	
	public Participation(Reservation reservation, Participant participant) {
		this.reservation = reservation;
		this.participant = participant;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public Participant getParticipant() {
		return participant;
	}


	public void setParticipant(Participant participant) {
		this.participant = participant;
	}


	@Override
	public String toString() {
		return "Participation [reservation=" + reservation + ", participant=" + participant + "]";
	}
	

}
