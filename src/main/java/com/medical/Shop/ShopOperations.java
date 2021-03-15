package com.medical.Shop;

import java.util.List;
import java.util.Scanner;

import com.medical.dao.IMedicineDAO;
import com.medical.dao.IPharmacyStockDAO;
import com.medical.dao.IPrescriptionDAO;
import com.medical.pojo.Medicine;
import com.medical.pojo.PharmacyStock;
import com.medical.pojo.Prescription;



public class ShopOperations {
		
	private IMedicineDAO medicineDAO;
	private IPharmacyStockDAO pharmacyStockDAO;
	private OrderOperations orderOperation;
	private IPrescriptionDAO prescriptionDAO;
	Scanner sc = new Scanner(System.in);

	public IMedicineDAO getMedicineDAO() {
		return medicineDAO;
	}

	public void setMedicineDAO(IMedicineDAO medicineDAO) {
		this.medicineDAO = medicineDAO;
	}
	
	

	public IPharmacyStockDAO getPharmacyStockDAO() {
		return pharmacyStockDAO;
	}

	public void setPharmacyStockDAO(IPharmacyStockDAO pharmacyStockDAO) {
		this.pharmacyStockDAO = pharmacyStockDAO;
	}

	public OrderOperations getOrderOperation() {
		return orderOperation;
	}

	public void setOrderOperation(OrderOperations orderOperation) {
		this.orderOperation = orderOperation;
	}

	/**
	 * Prints the list of medicine with there quantity available in pharmacy store
	 */
	public void showAllMedicine() {
		Medicine medicine;
		System.out.println("Medicine_Id         Name        Brand      Qauntity");
		for (PharmacyStock pharmacy : pharmacyStockDAO.getAll()) {
			medicine =pharmacy.getMedicine();
			System.out.println(medicine.getId() + "  " + medicine.getName() + "   "+medicine.getBrand()+"   " + pharmacy.getQuantity());
		}
	}

	/**
	 * Search the medicine name or brand available in store
	 * 
	 * @param medicine String medicine name or brand
	 * @return if found then returns the object otherwise returns null with message
	 *         on console.
	 */
	public List<Medicine> searchMedicine(String medicine) {
		List<Medicine> list = medicineDAO.getByName(medicine);
		if(list.isEmpty()) 
				list=medicineDAO.getByBrand(medicine);
		return list;
	}

	/**
	 * To Sell medicine to customer when he visits the store.
	 */
	public void sellMedicine(Prescription prescription) {
		for(Medicine medicine:prescription.getMedicines()) {
		PharmacyStock pharmacy=pharmacyStockDAO.getById(medicine.getId());
		checkStock(pharmacy, medicine.getQuantity());
		}
		System.out.println("Order Placed for ");
			System.out.println(prescription);
	}

	/**
	 * To Check the stock that parameterized medicine is available or not before
	 * selling them. warns the shopkeeper if stock is less then 25.
	 * 
	 * @param pharmacy that contains medicine details and quantity available in
	 *                 stock.
	 * @param quantity number of medicine required by customer
	 */
	public void checkStock(PharmacyStock pharmacy, int quantity) {
		if (pharmacy.getQuantity() > quantity) {
			pharmacy.setQuantity(pharmacy.getQuantity() - quantity);
			pharmacyStockDAO.update(pharmacy);
			if ((pharmacy.getQuantity() - 20) < quantity) {
				System.out.println("Stock running out. pls order stock");
			}
		} else {
			System.out.println("Shortage in Stock.Tell to visit again");
			System.out.println("Enter Quantity of medicine " + pharmacy.getMedicine().getName() + " to place order");
			quantity = sc.nextInt();
			orderOperation.placeOrder(pharmacy, quantity);
		}
	}

	public void insert() {
		
		/*
		 * PharmacyStock pharmacy=new PharmacyStock(); pharmacy.setMedicineId(38);
		 * pharmacy.setQuantity(100); pharmacyStockDAO.insert(pharmacy);
		 * pharmacy.setMedicineId(39); pharmacy.setQuantity(110);
		 * pharmacyStockDAO.insert(pharmacy);
		 */	/*
			 * pharmacy.setMedicineId(0); pharmacy.setQuantity(90);
			 * pharmacyStockDAO.insert(pharmacy);
			 */
		 
	}

	public IPrescriptionDAO getPrescriptionDAO() {
		return prescriptionDAO;
	}

	public void setPrescriptionDAO(IPrescriptionDAO prescriptionDAO) {
		this.prescriptionDAO = prescriptionDAO;
	}
	
}
