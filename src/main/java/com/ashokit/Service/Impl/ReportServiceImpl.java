package com.ashokit.Service.Impl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.Service.ReportService;
import com.ashokit.entity.InsurancePolicy;
import com.ashokit.repository.InsuranceRepository;
import com.ashokit.searchRequest.SearchRequest;
import com.ashokit.utility.EmailAttachments;
import com.ashokit.utility.ExportExcelGenerarotor;
import com.ashokit.utility.ExportPdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private InsuranceRepository repo;

	@Autowired
	private ExportExcelGenerarotor excelGenrator;

	@Autowired
	private ExportPdfGenerator pdfGenerator;

	@Autowired
	private EmailAttachments emailAtachments;

	@Override
	public List<String> getPlanName() {

		List<String> planName = repo.getPlanName();

		return planName;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getPlanStatus();

		return planStatus;
	}

	@Override
	public List<InsurancePolicy> search(SearchRequest request) {

		InsurancePolicy policy = new InsurancePolicy();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			policy.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			policy.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			policy.setGender(request.getGender());
		}
		if (null != request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {

			String startDate = request.getPlanStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate localDate = LocalDate.parse(startDate, formatter);
			policy.setPlanStartDate(localDate);
		}
		if (null != request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {

			String endDate = request.getPlanEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate localDate = LocalDate.parse(endDate, formatter);
			policy.setPlanEndDate(localDate);
		}
		// example class used for filtering the data
		List<InsurancePolicy> findAll = repo.findAll(Example.of(policy));
		return findAll;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File file = new File("policy.pdf");
		List<InsurancePolicy> findAll = repo.findAll();
		
		pdfGenerator.PdfGenrators(response, findAll,file);

		String subject = "test mail subject";
		String body = "<h1>test mail body";
		String to = "sriramvenky396@gmail.com";
		emailAtachments.sendEmailPdf(subject, body, to, file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		File file = new File("policy.xls");
		List<InsurancePolicy> findAll = repo.findAll();
		excelGenrator.ExcelGenerator(response, findAll, file);

		String subject = "test mail subject";
		String body = "<h1>test mail body";
		String to = "sriramvenky396@gmail.com";
		emailAtachments.sendEmail(subject, body, to, file);
		file.delete();
		return true;

	}
}
