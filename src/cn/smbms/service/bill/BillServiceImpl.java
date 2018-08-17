package cn.smbms.service.bill;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;

@Service
public class BillServiceImpl implements BillService{
    @Resource
    private BillMapper billMapper;
	
	@Override
	public List<Bill> getBillList(String productName, Integer providerId, Integer isPayment, Integer currentPageNo,Integer pageSize) throws Exception {
        currentPageNo=(currentPageNo-1)*pageSize;
		return billMapper.getBillList(productName, providerId, isPayment, currentPageNo, pageSize);
	}

	@Override
	public int getBillCount(String productName, Integer providerId, Integer isPayment) throws Exception {
		return billMapper.getBillCount(productName, providerId, isPayment);
	}

	@Override
	public boolean add(Bill bill) throws Exception {
		boolean flag=false;
		if(billMapper.add(bill)>0)
			flag=true;
		return flag;
	}

	@Override
	public Bill getBillById(Integer id) throws Exception {
		return billMapper.getBillById(id);
	}

	@Override
	public boolean modify(Bill bill) throws Exception {
		boolean flag=false;
		if(billMapper.modify(bill)>0)
			flag=true;
		return flag;
	}

	@Override
	public boolean deleteBillById(Integer delId) throws Exception {
		if(billMapper.deleteBillById(delId)>0){
	    return true;
	}
		return false;
	}
}
