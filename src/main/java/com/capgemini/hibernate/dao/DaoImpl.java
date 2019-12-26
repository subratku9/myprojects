package com.capgemini.hibernate.dao;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.hibernate.beans.Asset;
import com.capgemini.hibernate.beans.AssetAllocation;
import com.capgemini.hibernate.beans.AssetStatus;
import com.capgemini.hibernate.beans.Employee;
import com.capgemini.hibernate.beans.UserMaster;
import com.capgemini.hibernate.exceptions.AddAssetException;
import com.capgemini.hibernate.exceptions.AssetAllocationException;
import com.capgemini.hibernate.exceptions.GetAssetException;
import com.capgemini.hibernate.exceptions.RaiseAllocationException;
import com.capgemini.hibernate.exceptions.RemoveAssetException;
import com.capgemini.hibernate.exceptions.StatusException;
import com.capgemini.hibernate.exceptions.UpdateAssetException;

public class DaoImpl implements Dao 
{
	EntityManagerFactory entityManagerFactory = null;
	
	//user login 
	public UserMaster login(Integer userid, String password) 
	{
		UserMaster usermaster = new UserMaster();
		EntityManager entityManager = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select usertype from UserMaster where userid=:uid and userpassword=:upwd";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("uid", userid);
		query.setParameter("upwd", password);
		String user = (String) query.getSingleResult();
		usermaster.setUsertype(user);
		
		entityManager.close();
		return usermaster;
	}
    //adding assets
	public Asset addAsset(Asset asset) 
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			Asset asset1 = entityManager.find(Asset.class, asset.getAssetid());
			if (asset1 == null) 
			{
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(asset);
				entityTransaction.commit();
				return asset;
			}
			else 
			{
				throw new AddAssetException();
			}  
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		entityManager.close();
		return null;
	}
    //removing an asset
	public Asset removeAsset(Integer assetid)
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "Delete from Asset where assetid=:assid";
			Asset asset = entityManager.find(Asset.class, assetid);
			Query query = entityManager.createQuery(jpql);
			query.setParameter("assid", assetid);
			Integer i = query.executeUpdate();
			if (i > 0) 
			{
				entityTransaction.commit();
				return asset;
			}
			else
			{
				throw new RemoveAssetException();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
    //get the list of all assets
	public List<Asset> getAllAsset() 
	{
		EntityManager entityManager = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from Asset";
			TypedQuery<Asset> query = entityManager.createQuery(jpql, Asset.class);
			List<Asset> list = query.getResultList();
			if (!list.isEmpty()) 
			{
				return list;
			}
			else
			{
				throw new GetAssetException();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

		entityManager.close();
		return null;
	}
   
    //raise allocation
	public AssetAllocation raiseAllocation(AssetAllocation assetallocation) 
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try 
		{
			AssetStatus assetstatus = new AssetStatus();
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			AssetAllocation assetallocation1 = entityManager.find(AssetAllocation.class,
					assetallocation.getAllocationid());
			if (assetallocation1 == null)
			{
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(assetallocation);
				assetstatus.setAllocationid(assetallocation.getAllocationid());
				assetstatus.setStatus("null");
				entityManager.persist(assetstatus);
				entityTransaction.commit();
				return assetallocation;
			}
			else
			{
				throw new RaiseAllocationException();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		entityManager.close();
		return null;
	}
    //get all assets allocation
	public List<AssetAllocation> getAllAssetAllocation() 
	{
		EntityManager entityManager = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from AssetAllocation";
			Query query = entityManager.createQuery(jpql);
			List<AssetAllocation> list = query.getResultList();
			if (!list.isEmpty())
			{
				return list;
			} 
			else 
			{
				throw new AssetAllocationException();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		entityManager.close();
		return null;
	}
    //set status
	public Boolean setStatus(Integer allocationid, String status)
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "UPDATE AssetStatus SET status=:asname WHERE allocationid=:allocid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("asname", status);
			query.setParameter("allocid", allocationid);
			Integer i = query.executeUpdate();
			if (i > 0) 
			{
				entityTransaction.commit();
				return true;
			} 
			else
			{
				throw new StatusException();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
    //view the status
	public String viewStatus(Integer allocationid)
	{
		EntityManager entityManager = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from AssetStatus where allocationid=:allocid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("allocid", allocationid);
			List<AssetStatus> list = query.getResultList();
			for (AssetStatus assetstatus : list)
			{
				System.out.println(assetstatus.getAllocationid());
				if (assetstatus.getStatus().equals("null"))
				{
					return "Status is not updated till now";
				}
				else 
				{
					return assetstatus.getStatus();
				}
			}
			throw new StatusException();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "enter valid allocation id";
	}
   //update asset name
	public Asset updateAssetName(Integer assetid, String assetname)
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset = entityManager.find(Asset.class, assetid);
			entityTransaction.begin();
			String jpql = "UPDATE Asset SET assetname=:asname WHERE assetid=:aid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("asname", assetname);
			query.setParameter("aid", assetid);
			Integer i = query.executeUpdate();
			if (i > 0) 
			{
				asset.setAssetname(assetname);
				entityTransaction.commit();
				return asset;
			}
			else
			{
				throw new UpdateAssetException();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
    //update the asset description
	public Asset updateAssetDes(Integer assetid, String assetdescription) 
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset1 = entityManager.find(Asset.class, assetid);
			entityTransaction.begin();
			String jpql = "UPDATE Asset SET assetdes=:asdes WHERE assetid=:aid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("asdes", assetdescription);
			query.setParameter("aid", assetid);
			Integer i = query.executeUpdate();
			if (i > 0) 
			{
				asset1.setAssetdes(assetdescription);
				entityTransaction.commit();
				return asset1;
			}
			else 
			{
				throw new UpdateAssetException();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
   //update the asset quantity
	public Asset updateAssetQuantity(Integer assetid, Integer quantity) 
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset2 = entityManager.find(Asset.class, assetid);
			entityTransaction.begin();
			String jpql2 = "UPDATE Asset SET quantity=:aquan WHERE assetid=:aid";
			Query query2 = entityManager.createQuery(jpql2);
			query2.setParameter("aquan", quantity);
			query2.setParameter("aid", assetid);
			Integer i2 = query2.executeUpdate();
			if (i2 > 0) 
			{
				asset2.setQuantity(quantity);
				entityTransaction.commit();
				return asset2;
			}
			else
			{
				throw new UpdateAssetException();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
    //update the asset status
	public Asset updateAssetStatus(Integer assetid, String assetstatus)
	{
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("asset_management");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			Asset asset3 = entityManager.find(Asset.class, assetid);
			entityTransaction.begin();
			String jpql3 = "UPDATE Asset SET status=:assetstatus WHERE assetid=:aid";
			Query query3 = entityManager.createQuery(jpql3);
			query3.setParameter("assetstatus", assetstatus);
			query3.setParameter("aid", assetid);
			Integer i3 = query3.executeUpdate();
			if (i3 > 0) 
			{
				asset3.setStatus(assetstatus);
				entityTransaction.commit();
				return asset3;
			}
			else 
			{
				throw new UpdateAssetException();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
