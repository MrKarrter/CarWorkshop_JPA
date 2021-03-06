package uo.ri.ui.foreman.action.client;

import java.util.List;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.ForemanService;
import uo.ri.business.dto.ClientDto;
import uo.ri.conf.Factory;
import uo.ri.ui.util.Printer;
import uo.ri.util.exception.BusinessException;

/**
 * Interacción con el usuario para listar los usuarios que han sido recomendados
 * por un cliente determinado
 * 
 * @author José Antonio García García
 *
 */
public class FindRecomendedClientsByClientIdAction implements Action {

	@Override
	public void execute() throws BusinessException {

		Long id = Console.readLong("Id del cliente");

		ForemanService fs = Factory.service.forForeman();

		List<ClientDto> clients = fs.findRecomendedClientsByClienteId(id);
		Console.println("\nListado de clientes recomendados\n");
		Console.println("Formato: id, dni, nombre, apellidos, ciudad, calle, "
				+ "codigo postal, email, telefono");
		for (ClientDto c : clients) {
			Printer.printClient(c);
		}

	}
}
