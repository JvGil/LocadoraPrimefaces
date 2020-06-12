package br.com.foursys.locadora.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import br.com.caelum.stella.validation.CPFValidator;

public class Valida {
	public static boolean vazio(String aux) {
		if (aux == null)
			return true;
		if (aux.equals("R$0,00"))
			return true;
		
		aux = aux.replace(".", " ");
		aux = aux.replace("-", " ");
		aux = aux.replace("/", " ");
		aux = aux.replace("(", " ");
		aux = aux.replace(")", " ");
		if (aux.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean numero(double numero) {
		return numero<=0;
	}

	public static boolean cpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			if (cpf.equals("000.000.000-00"))
				return true;
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean rg(String rg) {
		rg = rg.replace(".", "").replace("-", "");
		int i = -1;
		int a = Integer.parseInt(rg.substring(0, 1));
		int b = Integer.parseInt(rg.substring(1, 2));
		int c = Integer.parseInt(rg.substring(2, 3));
		int d = Integer.parseInt(rg.substring(3, 4));
		int e = Integer.parseInt(rg.substring(4, 5));
		int f = Integer.parseInt(rg.substring(5, 6));
		int g = Integer.parseInt(rg.substring(6, 7));
		int h = Integer.parseInt(rg.substring(7, 8));

		if ((!rg.substring(8, 9).equals("0") && !rg.substring(8, 9).equals("1") && !rg.substring(8, 9).equals("2")
				&& !rg.substring(8, 9).equals("3") && !rg.substring(8, 9).equals("4") && !rg.substring(8, 9).equals("5")
				&& !rg.substring(8, 9).equals("6") && !rg.substring(8, 9).equals("7") && !rg.substring(8, 9).equals("8")
				&& !rg.substring(8, 9).equals("9") && !rg.substring(8, 9).equals("X"))|| rg.equals("000000000")) {
			return true;
		} else if (rg.substring(8, 9).equals("X")) {
			i = 10;
		} else {
			i = Integer.parseInt(rg.substring(8, 9));
		}

		int total = (a * 9) + (b * 8) + (c * 7) + (d * 6) + (e * 5) + (f * 4) + (g * 3) + (h * 2);

		return (total % 11) != i;
	}
	
	public static boolean data(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(data);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVerificada = LocalDate.parse(data, dtf); 
            LocalDate hoje = LocalDate.now();
            return dataVerificada.compareTo(hoje) > 0;
        } catch (ParseException ex) {
            return true;
        }
    }
	
	public static boolean dataDevolucao(String data) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			sdf.parse(data);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataVerificada = LocalDate.parse(data, dtf); 
			LocalDate hoje = LocalDate.now();
			return dataVerificada.compareTo(hoje) < 0;
		} catch (ParseException ex) {
			return true;
		}
	}
	
	public static int retornaIdade(String data) {
		int idade = 0;
		Date data1;
		try {
			data1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Date data2 = new Date();
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(data1);
			cal2.setTime(data2);
			int year1 = cal1.get(Calendar.YEAR);
			int year2 = cal2.get(Calendar.YEAR);
			int month1 = cal1.get(Calendar.MONTH);
			int month2 = cal2.get(Calendar.MONTH);
			int day1 = cal1.get(Calendar.DAY_OF_MONTH);
			int day2 = cal2.get(Calendar.DAY_OF_MONTH);
			idade = year2 - year1;
			if ((month2 > month1) || ((month2 == month1) && (day2 < day1))) {
				idade -= 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return idade;
	}
}
