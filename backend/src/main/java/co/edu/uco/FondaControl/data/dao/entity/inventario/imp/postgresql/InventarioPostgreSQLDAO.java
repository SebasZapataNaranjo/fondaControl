package co.edu.uco.FondaControl.data.dao.entity.inventario.imp.postgresql;

import co.edu.uco.FondaControl.data.dao.entity.inventario.InventarioDAO;
import co.edu.uco.FondaControl.entity.InventarioEntity;
import co.edu.uco.FondaControl.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.FondaControl.crosscutting.excepciones.DataFondaControlException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventarioPostgreSQLDAO implements InventarioDAO {
    private final Connection connection;

    public InventarioPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(InventarioEntity entity) throws DataFondaControlException {
        validarEntidad(entity);

        var sentenciaSQL = new StringBuilder("INSERT INTO inventario (codigo, nombreproducto, cantidad, codigoindicador) VALUES (?, ?, ?, ?)");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSQL.toString())) {
            preparedStatement.setObject(1, entity.getCodigo());
            preparedStatement.setString(2, entity.getNombreProducto());
            preparedStatement.setInt(3, entity.getCantidad());
            preparedStatement.setObject(4, entity.getCodigoIndicador());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw DataFondaControlException.reportar(
                    "Error al crear el inventario.",
                    "SQLException al crear el inventario: " + exception.getMessage(),
                    exception
            );
        } catch (Exception exception) {
            throw DataFondaControlException.reportar(
                    "Error inesperado al crear el inventario.",
                    "Excepción no controlada al crear el inventario: " + exception.getMessage(),
                    exception
            );
        }
    }

    @Override
    public List<InventarioEntity> listByFilter(InventarioEntity entity) throws DataFondaControlException {
        if (entity.getNombreProducto() != null && entity.getNombreProducto().length() > 50) {
            throw new IllegalArgumentException("El nombre del producto no puede exceder los 50 caracteres.");
        }

        var sentenciaSQL = new StringBuilder("SELECT codigo, nombreproducto, cantidad, codigoindicador FROM inventario WHERE nombreproducto LIKE ?");
        List<InventarioEntity> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSQL.toString())) {
            preparedStatement.setString(1, "%" + entity.getNombreProducto() + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(mapToEntity(resultSet));
                }
            }
        } catch (SQLException exception) {
            throw DataFondaControlException.reportar(
                    "Error al listar los inventarios por filtro.",
                    "SQLException al listar inventarios por filtro: " + exception.getMessage(),
                    exception
            );
        } catch (Exception exception) {
            throw DataFondaControlException.reportar(
                    "Error inesperado al listar los inventarios por filtro.",
                    "Excepción no controlada al listar inventarios por filtro: " + exception.getMessage(),
                    exception
            );
        }
        return result;
    }

    @Override
    public List<InventarioEntity> listAll() throws DataFondaControlException {
        var sentenciaSQL = new StringBuilder("SELECT codigo, nombreproducto, cantidad, codigoindicador FROM inventario");
        List<InventarioEntity> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSQL.toString());
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                result.add(mapToEntity(resultSet));
            }
        } catch (SQLException exception) {
            throw DataFondaControlException.reportar(
                    "Error al listar todos los inventarios.",
                    "SQLException al listar todos los inventarios: " + exception.getMessage(),
                    exception
            );
        } catch (Exception exception) {
            throw DataFondaControlException.reportar(
                    "Error inesperado al listar todos los inventarios.",
                    "Excepción no controlada al listar todos los inventarios: " + exception.getMessage(),
                    exception
            );
        }
        return result;
    }

    @Override
    public List<InventarioEntity> listByCodigo(UUID uuid) throws DataFondaControlException {
        if (UtilObjeto.esNulo(uuid)) {
            throw new IllegalArgumentException("El UUID no puede ser nulo.");
        }

        var sentenciaSQL = new StringBuilder("SELECT codigo, nombreproducto, cantidad, codigoindicador FROM inventario WHERE codigo = ?");
        List<InventarioEntity> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSQL.toString())) {
            preparedStatement.setObject(1, uuid);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(mapToEntity(resultSet));
                }
            }
        } catch (SQLException exception) {
            throw DataFondaControlException.reportar(
                    "Error al listar los inventarios por código.",
                    "SQLException al listar inventarios por código: " + exception.getMessage(),
                    exception
            );
        } catch (Exception exception) {
            throw DataFondaControlException.reportar(
                    "Error inesperado al listar los inventarios por código.",
                    "Excepción no controlada al listar inventarios por código: " + exception.getMessage(),
                    exception
            );
        }
        return result;
    }

    @Override
    public void update(UUID uuid, InventarioEntity entity) throws DataFondaControlException {
        if (UtilObjeto.esNulo(uuid)) {
            throw new IllegalArgumentException("El UUID no puede ser nulo.");
        }
        validarEntidad(entity);

        var sentenciaSQL = new StringBuilder("UPDATE inventario SET nombreproducto = ?, cantidad = ?, codigoindicador = ? WHERE codigo = ?");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSQL.toString())) {
            preparedStatement.setString(1, entity.getNombreProducto());
            preparedStatement.setInt(2, entity.getCantidad());
            preparedStatement.setObject(3, entity.getCodigoIndicador());
            preparedStatement.setObject(4, uuid);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated == 0) {
                throw DataFondaControlException.reportar(
                        "No se encontró el registro para actualizar.",
                        "No hay registro con el código especificado: " + uuid
                );
            }
        } catch (SQLException exception) {
            throw DataFondaControlException.reportar(
                    "Error al actualizar el inventario.",
                    "SQLException al actualizar el inventario: " + exception.getMessage(),
                    exception
            );
        } catch (Exception exception) {
            throw DataFondaControlException.reportar(
                    "Error inesperado al actualizar el inventario.",
                    "Excepción no controlada al actualizar el inventario: " + exception.getMessage(),
                    exception
            );
        }
    }

    @Override
    public InventarioEntity findById(UUID codigo) throws DataFondaControlException {
        if (UtilObjeto.esNulo(codigo)) {
            throw new IllegalArgumentException("El código no puede ser nulo.");
        }

        var sentenciaSQL = new StringBuilder("SELECT codigo, nombreproducto, cantidad, codigoindicador FROM inventario WHERE codigo = ?");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSQL.toString())) {
            preparedStatement.setObject(1, codigo);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapToEntity(resultSet);
                }
            }
        } catch (SQLException exception) {
            throw DataFondaControlException.reportar(
                    "Error al buscar el inventario por ID.",
                    "SQLException al buscar inventario por ID: " + exception.getMessage(),
                    exception
            );
        } catch (Exception exception) {
            throw DataFondaControlException.reportar(
                    "Error inesperado al buscar el inventario por ID.",
                    "Excepción no controlada al buscar inventario por ID: " + exception.getMessage(),
                    exception
            );
        }
        return null;
    }

    @Override
    public void createOrUpdate(InventarioEntity entity) throws DataFondaControlException {
        validarEntidad(entity);
        if (findById(entity.getCodigo()) == null) {
            create(entity);
        } else {
            update(entity.getCodigo(), entity);
        }
    }

    private InventarioEntity mapToEntity(ResultSet resultSet) throws SQLException {
        return new InventarioEntity(
                (UUID) resultSet.getObject("codigo"),
                resultSet.getString("nombreproducto"),
                resultSet.getInt("cantidad"),
                (UUID) resultSet.getObject("codigoindicador")
        );
    }

    private void validarEntidad(InventarioEntity entity) {
        if (UtilObjeto.esNulo(entity)) {
            throw new IllegalArgumentException("La entidad no puede ser nula.");
        }
        if (entity.getNombreProducto() == null || entity.getNombreProducto().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo ni vacío.");
        }
        if (entity.getNombreProducto().length() > 50) {
            throw new IllegalArgumentException("El nombre del producto no puede exceder los 50 caracteres.");
        }
    }
}
