package com.bd.eshopper.avion.metier;

import com.bd.eshopper.avion.entity.TerminalAero;
import java.util.List;


public interface TerminalAeroMetier {
	
	public TerminalAero findOne(Long id) ;
	public List<TerminalAero> getAll();
	public TerminalAero save(TerminalAero o) ;
	public TerminalAero update(TerminalAero o) ;
	public String delete(Long id) ;
}
