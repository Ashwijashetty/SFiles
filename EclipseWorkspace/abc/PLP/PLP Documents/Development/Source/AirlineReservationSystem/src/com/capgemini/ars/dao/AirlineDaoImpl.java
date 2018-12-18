package com.capgemini.ars.dao;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.capgemini.ars.bean.BookingInformationBean;
import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.bean.UserBean;
import com.capgemini.ars.exception.AirlineException;

@Repository("airlineDao")
@Transactional
public class AirlineDaoImpl implements IAirlineDao {
	@PersistenceContext
	EntityManager entityManager;
	ArrayList<FlightInformationBean> flightList = null;
	FlightInformationBean flightDetails = null;
	BookingInformationBean bookingDetails = null;
	UserBean userDetails = null;
	ArrayList<String> cityList = null;
	Logger logger=Logger.getLogger(AirlineDaoImpl.class);

	public AirlineDaoImpl() {
	}

	@Override
	public ArrayList<FlightInformationBean> fetchAvailableFlights(
			FlightInformationBean flightInfo, String classType,
			int noOfPassengers) throws AirlineException {
		if (classType.equalsIgnoreCase("first")) {
			String fetchFlightQuery = IQueryMapper.CHECK_FIRST_CLASS_AVAILABILITY;
			try {
				TypedQuery<FlightInformationBean> tq = entityManager
						.createQuery(fetchFlightQuery,
								FlightInformationBean.class);
				tq.setParameter("dc", flightInfo.getDeptCity());
				tq.setParameter("ac", flightInfo.getArrCity());
				tq.setParameter("dt", flightInfo.getDeptDate());
				tq.setParameter("fs", noOfPassengers);
				flightList = (ArrayList<FlightInformationBean>) tq
						.getResultList();
			} catch (Exception e) {
				logger.info(e.getMessage());
				throw new AirlineException("Due to some technical problems,transaction cannot be initiated");
			}

			finally {
				if (entityManager != null) {
					logger.info("entity manager is closed");
					entityManager.close();
				}
			}
		} else if (classType.equalsIgnoreCase("business")) {
			String fetchFlightQuery = IQueryMapper.CHECK_BUSINESS_CLASS_AVAILABILITY;
			try {
				TypedQuery<FlightInformationBean> tq = entityManager
						.createQuery(fetchFlightQuery,
								FlightInformationBean.class);
				tq.setParameter("dc", flightInfo.getDeptCity());
				tq.setParameter("ac", flightInfo.getArrCity());
				tq.setParameter("dt", flightInfo.getDeptDate());
				tq.setParameter("bs", noOfPassengers);
				flightList = (ArrayList<FlightInformationBean>) tq
						.getResultList();
			} catch (Exception e) {
				logger.info(e.getMessage());
				throw new AirlineException(e.toString());
			} finally {
				if (entityManager != null) {
					logger.info("entity manager is closed");
					entityManager.close();
				}
			}
		}
		return flightList;
	}

	@Override
	public int bookFlight(BookingInformationBean bookingInfo, int passengers)
			throws AirlineException {
		decOccupancy(bookingInfo, passengers);
		bookDetails(bookingInfo);
		int bookingId = bookingInfo.getBookingId();
		return bookingId;
	}

	private void decOccupancy(BookingInformationBean bookingInfo, int passengers)
			throws AirlineException {
		if (bookingInfo.getClassType().equalsIgnoreCase("first")) {
			String updateQuery = IQueryMapper.DEC_FIRST_CLASS_OCCUPANCY;
			try {
				Query qry = entityManager.createQuery(updateQuery);
				qry.setParameter("pn", passengers);
				qry.setParameter("fn", bookingInfo.getFlightNo());
				qry.executeUpdate();
			} catch (Exception e) {
				logger.info(e.getMessage());
				throw new AirlineException(e.getMessage());
			} finally {
				if (entityManager != null) {
					logger.info("entity manager is closed");
					entityManager.close();
				}
			}
		} else if (bookingInfo.getClassType().equalsIgnoreCase("business")) {
			String updateQuery = IQueryMapper.DEC_BUSINESS_CLASS_OCCUPANCY;
			try {
				Query qry = entityManager.createQuery(updateQuery);
				qry.setParameter("pn", passengers);
				qry.setParameter("fn", bookingInfo.getFlightNo());
				qry.executeUpdate();
			} catch (Exception e) {
				logger.info(e.getMessage());
				throw new AirlineException(e.getMessage());
			} finally {
				if (entityManager != null) {
					logger.info("entity manager is closed");
					entityManager.close();
				}
			}
		}
	}

	public boolean bookDetails(BookingInformationBean bookingInfo)
			throws AirlineException {
		try {
			entityManager.persist(bookingInfo);
			entityManager.flush();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return true;
	}

	@Override
	public boolean rescheduleBooking(BookingInformationBean bookingInfo,
			int flightNo, int passengers) throws AirlineException {
		incOccupancy(bookingInfo, passengers);
		bookingInfo.setFlightNo(flightNo);
		decOccupancy(bookingInfo, bookingInfo.getNoOfPassengers());

		String updateQuery = IQueryMapper.UPDATE_BOOKING_INFORMATION;
		try {
			Query qry = entityManager.createQuery(updateQuery);
			qry.setParameter("fn", flightNo);
			qry.setParameter("bi", bookingInfo.getBookingId());
			qry.executeUpdate();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return true;
	}

	private void incOccupancy(BookingInformationBean bookingInfo, int passengers)
			throws AirlineException {
		if (bookingInfo.getClassType().equals("first")) {
			String updateQuery = IQueryMapper.INC_FIRST_CLASS_OCCUPANCY;
			try {
				Query qry = entityManager.createQuery(updateQuery);
				qry.setParameter("pn", passengers);
				qry.setParameter("fn", bookingInfo.getFlightNo());
				qry.executeUpdate();
			} catch (Exception e) {
				logger.info(e.getMessage());
				throw new AirlineException(e.getMessage());
			} finally {
				if (entityManager != null) {
					logger.info("entity manager is closed");
					entityManager.close();
				}
			}
		} else if (bookingInfo.getClassType().equals("business")) {
			String updateQuery = IQueryMapper.INC_BUSINESS_CLASS_OCCUPANCY;
			try {
				Query qry = entityManager.createQuery(updateQuery);
				qry.setParameter("pn", passengers);
				qry.setParameter("fn", bookingInfo.getFlightNo());
				qry.executeUpdate();
			} catch (Exception e) {
				logger.info(e.getMessage());
				throw new AirlineException(e.getMessage());
			} finally {
				if (entityManager != null) {
					logger.info("entity manager is closed");
					entityManager.close();
				}
			}

		}
	}

	@Override
	public boolean cancelBooking(int bookingId, int passengers)
			throws AirlineException {
		bookingDetails = retrieveBookingDetails(bookingId);
		try {
			entityManager.remove(bookingDetails);
			entityManager.flush();
			incOccupancy(bookingDetails, passengers);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}

		return true;
	}

	@Override
	public BookingInformationBean retrieveBookingDetails(int bookingId)
			throws AirlineException {
		try {
			bookingDetails = entityManager.find(BookingInformationBean.class,
					bookingId);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return bookingDetails;
	}

	@Override
	public UserBean isValidUserLogin(UserBean userDetails)
			throws AirlineException {
		UserBean usr;
		try {
			usr = entityManager.find(UserBean.class, userDetails.getUserName());
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closeds");
				entityManager.close();
			}
		}
		if (usr != null && userDetails.getPassword().equals(usr.getPassword()))
			return usr;
		else
		{	
			logger.info("Username or password does not match");
			throw new AirlineException("Username or password does not match");
		}
	}

	@Override
	public ArrayList<FlightInformationBean> fetchGivenPeriodFlights(
			String airline, Date deptDate1, String deptTime1, Date deptDate2,
			String deptTime2) throws AirlineException {
		// Date date1 = Date.valueOf(deptDate1);
		// Date date2 = Date.valueOf(deptDate2);
		String fetchFlightQuery = IQueryMapper.FETCH_FLIGHT_GIVEN_AIRLINE_AND_PERIOD;
		try {
			TypedQuery<FlightInformationBean> tq = entityManager.createQuery(
					fetchFlightQuery, FlightInformationBean.class);
			tq.setParameter("air", airline);
			tq.setParameter("fd", deptDate1);
			tq.setParameter("ld", deptDate2);
			tq.setParameter("ft", deptTime1);
			tq.setParameter("lt", deptTime2);
			flightList = (ArrayList<FlightInformationBean>) tq.getResultList();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return flightList;
	}

	@Override
	public ArrayList<FlightInformationBean> fetchGivenCityFlights(
			String srcCity, String destCity) throws AirlineException {
		String fetchFlightQuery = IQueryMapper.FETCH_FLIGHT_GIVEN_SOURCE_AND_DESTINATION;
		try {
			TypedQuery<FlightInformationBean> tq = entityManager.createQuery(
					fetchFlightQuery, FlightInformationBean.class);
			tq.setParameter("dc", srcCity);
			tq.setParameter("ac", destCity);
			flightList = (ArrayList<FlightInformationBean>) tq.getResultList();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return flightList;
	}

	@Override
	public int insertFlight(FlightInformationBean flightInfo)
			throws AirlineException {
		// String fetchFlightQuery =IQueryMapper.FETCH_FLIGHT_NO;
		// Date deptDate = Date.valueOf(flightInfo.getDeptDate());
		try {
			entityManager.persist(flightInfo);
			entityManager.flush();
			/*
			 * TypedQuery<String> tq =
			 * entityManager.createQuery(fetchFlightQuery,String.class);
			 * flightNo = Integer.parseInt(tq.getSingleResult());
			 */
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return flightInfo.getFlightNo();
	}

	@Override
	public ArrayList<FlightInformationBean> retrieveAllFlights()
			throws AirlineException {
		String fetchFlightQuery = IQueryMapper.RETRIEVE_ALL_FLIGHTS;
		try {
			TypedQuery<FlightInformationBean> tq = entityManager.createQuery(
					fetchFlightQuery, FlightInformationBean.class);
			flightList = (ArrayList<FlightInformationBean>) tq.getResultList();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return flightList;
	}

	@Override
	public FlightInformationBean retrieveFlightDetails(int flightNo)
			throws AirlineException {
		try
		{
		flightDetails = entityManager.find(FlightInformationBean.class,
				flightNo);
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		}
		finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return flightDetails;
	}

	@Override
	public int updateFlight(FlightInformationBean bean) throws AirlineException {
		int dataUpdated = -1;
		// Date date1 = Date.valueOf(bean.getDeptDate());
		// Date date2 = Date.valueOf(bean.getArrDate());
		String updateQuery = IQueryMapper.UPDATE_FLIGHT_DETAILS;
		try {
			Query qry = entityManager.createQuery(updateQuery);
			qry.setParameter("dc", bean.getDeptCity());
			qry.setParameter("ac", bean.getArrCity());
			qry.setParameter("dd", bean.getDeptDate());
			qry.setParameter("ad", bean.getArrDate());
			qry.setParameter("dt", bean.getDeptTime());
			qry.setParameter("at", bean.getArrTime());
			qry.setParameter("fs", bean.getFirstSeats());
			qry.setParameter("fsf", bean.getFirstSeatsFare());
			qry.setParameter("bs", bean.getBussSeats());
			qry.setParameter("bsf", bean.getBussSeatsFare());
			qry.setParameter("fn", bean.getFlightNo());
			dataUpdated = qry.executeUpdate();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return dataUpdated;
	}

	@Override
	public boolean deleteFlight(int flightNo) throws AirlineException {
		try {
			flightDetails = entityManager.find(FlightInformationBean.class,
					flightNo);
			entityManager.remove(flightDetails);
			entityManager.flush();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closed");
				entityManager.close();
			}
		}
		return true;
	}

	@Override
	public ArrayList<String> getCityList() throws AirlineException {
		String fetchCityQuery = IQueryMapper.RETRIEVE_ALL_LOCATIONS;
		try {
			TypedQuery<String> tq = entityManager.createQuery(fetchCityQuery,
					String.class);
			cityList = (ArrayList<String>) tq.getResultList();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new AirlineException(e.getMessage());
		} finally {
			if (entityManager != null) {
				logger.info("entity manager is closeds");
				entityManager.close();
			}
		}
		return cityList;
	}
}
