package com.xworkz.springmvc.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.springmvc.dao.CalamitiesDAO;
import com.xworkz.springmvc.dto.CalamitiesDTO;


@Component
public class CalamitiesServiceImpl implements CalamitiesService{

	@Autowired
	private CalamitiesDAO dao;

	public CalamitiesServiceImpl() {
		System.out.println("created"+this.getClass().getSimpleName());
	}

	@Override
	public int createAndValidate(CalamitiesDTO dto) {
		System.out.println("invoked createAndValidate method in CalamitiesServiceImpl " + dto);
		/* for valid=0 & for invalid=1 */
		int valid = 1;
		try {
			if (Objects.nonNull(dto)) {
				System.out.println("CalamitiesDTO not null can save");
				if (dto.getPlace() != null) {
					System.out.println("CalamitiesDTO place not null can save");
					valid = 0;

				} else {
					System.out.println("CalamitiesDTO place is null can't save");
				}
				if (dto.getDate() != null) {
					System.out.println("CalamitiesDTO date not null can save");
					valid = 0;

				} else {
					System.out.println("CalamitiesDTO date is null can't save");
				}
				if (dto.getCalamityType() != null) {
					System.out.println("CalamitiesDTO CalamityType not null can save");
					valid = 0;

				} else {
					System.out.println("CalamitiesDTO CalamityType is null can't save");
				}
				if (valid == 0) {
					System.out.println("CalamitiesDTO is valid can save it..");
					dao.create(dto);	  
				} else {
					System.out.println("CalamitiesDTO not valid can't save it..");
				}

			} else {
				System.out.println("CalamitiesDTO is null can't save");

			}
		} catch (Exception e) {
			System.err.println("Exception in createAndValidate in CalamitiesServiceImpl" + e.getMessage());
		}
		return 0;
	}

	
}
