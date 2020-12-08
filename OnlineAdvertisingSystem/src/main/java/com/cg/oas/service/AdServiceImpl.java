package com.cg.oas.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dao.AdDAO;
import com.cg.oas.dao.AdDAOImpl;
import com.cg.oas.dto.Ad;
import com.cg.oas.entity.AdEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;
import com.cg.oas.utils.AdAppUtils;
public class AdServiceImpl implements AdService{
		
		private static Logger logger = LogManager.getLogger(AdServiceImpl.class.getName());
		AdDAO adDAO=new AdDAOImpl();
		
		public Ad addData(AdEntity adEntity) throws InvalidDataFormatException
		{
				
				AdEntity adEntity1=adDAO.postNewAdvertise(adEntity);
				return AdAppUtils.convertUserEntityToUser(adEntity1);
			
		}

	}

