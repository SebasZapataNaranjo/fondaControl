package co.edu.uco.FondaControl.businesslogic.businesslogic.domain;

import co.edu.uco.FondaControl.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.FondaControl.crosscutting.utilitarios.UtilMoneda;
import co.edu.uco.FondaControl.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.FondaControl.crosscutting.utilitarios.UtilUUID;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class InformeCajaDomain {

    private UUID codigo;
    private UUID codigoSesionTrabajo;
    private LocalDate fecha;
    private BigDecimal totalVenta;
    private BigDecimal pagoEfectivo;
    private BigDecimal pagoTransferencia;
    private Collection<Venta> ventas;

    InformeCajaDomain() {
        setCodigo(UtilUUID.obtenerValorDefecto());
        setCodigoSesionTrabajo(UtilUUID.obtenerValorDefecto());
        setFecha(UtilFecha.obtenerValorDefecto().toLocalDate());
        setTotalVenta(UtilMoneda.obtenerValorDefecto());
        setPagoEfectivo(UtilMoneda.obtenerValorDefecto());
        setPagoTransferencia(UtilMoneda.obtenerValorDefecto());
        setVentas(new ArrayList<>());
    }

    public InformeCajaDomain(final UUID codigo, final UUID codigoSesionTrabajo, final LocalDate fecha,
                             final BigDecimal totalVenta, final BigDecimal pagoEfectivo, final BigDecimal pagoTransferencia,
                             final Collection<Venta> ventas) {
        setCodigo(codigo);
        setCodigoSesionTrabajo(codigoSesionTrabajo);
        setFecha(fecha);
        setTotalVenta(totalVenta);
        setPagoEfectivo(pagoEfectivo);
        setPagoTransferencia(pagoTransferencia);
        setVentas(ventas);
    }

    public static InformeCajaDomain obtenerValorDefecto() {
        return new InformeCajaDomain();
    }

    public UUID getCodigo() {
        return codigo;
    }

    private void setCodigo(final UUID codigo) {
        this.codigo = UtilUUID.obtenerValorDefecto(codigo);
    }

    public UUID getCodigoSesionTrabajo() {
        return codigoSesionTrabajo;
    }

    private void setCodigoSesionTrabajo(final UUID codigoSesionTrabajo) {
        this.codigoSesionTrabajo = UtilUUID.obtenerValorDefecto(codigoSesionTrabajo);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    private void setFecha(final LocalDate fecha) {
        this.fecha = UtilObjeto.getInstancia().esNulo(fecha) ? UtilFecha.obtenerValorDefecto().toLocalDate() : fecha;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = UtilMoneda.asegurarNoNegativo(totalVenta);
    }

    public BigDecimal getPagoEfectivo() {
        return pagoEfectivo;
    }

    private void setPagoEfectivo(final BigDecimal pagoEfectivo) {
        this.pagoEfectivo = UtilMoneda.asegurarNoNegativo(pagoEfectivo);
    }

    public BigDecimal getPagoTransferencia() {
        return pagoTransferencia;
    }

    private void setPagoTransferencia(final BigDecimal pagoTransferencia) {
        this.pagoTransferencia = UtilMoneda.asegurarNoNegativo(pagoTransferencia);
    }

    public Collection<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Collection<Venta> ventas) {
        this.ventas = UtilObjeto.getInstancia().esNulo(ventas) ? new ArrayList<>() : ventas;
    }

    // Subclase interna para representar una venta individual
    public static final class Venta {
        private BigDecimal monto;

        public Venta(BigDecimal monto) {
            this.monto = UtilMoneda.asegurarNoNegativo(monto);
        }

        public BigDecimal getMonto() {
            return monto;
        }

        public void setMonto(BigDecimal monto) {
            this.monto = UtilMoneda.asegurarNoNegativo(monto);
        }
    }
}
