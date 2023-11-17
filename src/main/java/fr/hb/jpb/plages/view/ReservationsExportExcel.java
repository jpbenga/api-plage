package fr.hb.jpb.plages.view;

import fr.hb.jpb.plages.business.Reservation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ReservationsExportExcel extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.addHeader("Content-Disposition", "attachment; filename=Reservations.xls");
        Sheet sheet = workbook.createSheet("Réservations");
        List<Reservation> reservations = (List<Reservation>) model.get("reservations");
        for(int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(reservation.getClient().getNom() + " " + reservation.getClient().getPrenom());
            cell = row.createCell(1);
            cell.setCellValue(reservation.getDateDebut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cell = row.createCell(2);
            cell.setCellValue(reservation.getDateFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cell = row.createCell(3);
            cell.setCellValue(reservation.getMontantARegler() + "€");
            cell = row.createCell(4);
            cell.setCellValue(reservation.getStatut().getNom());
        }
    }
}