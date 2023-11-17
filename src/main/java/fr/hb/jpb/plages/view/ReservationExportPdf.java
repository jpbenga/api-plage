package fr.hb.jpb.plages.view;

import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Table;
import fr.hb.jpb.plages.business.Reservation;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public class ReservationExportPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        Reservation reservation = (Reservation) model.get("reservation");

        Table table = new Table(7);
        table.addCell("Client");
        table.addCell("Date Debut");
        table.addCell("Date Fin");
        table.addCell("Montant");
        table.addCell("Carte Bancaire");
        table.addCell("Date Expiration");
        table.addCell("Status");

        table.addCell(reservation.getClient().getNom() + " " + reservation.getClient().getPrenom());
        table.addCell(reservation.getDateDebut().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
        table.addCell(reservation.getDateFin().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
        table.addCell(String.valueOf(reservation.getMontantARegler()));
        table.addCell(reservation.getNumeroCarte());
        table.addCell(reservation.getMoisExpiration() + "/" + reservation.getAnneeExpiration());
        table.addCell(reservation.getStatut().getNom());
        document.add(table);
    }
}
