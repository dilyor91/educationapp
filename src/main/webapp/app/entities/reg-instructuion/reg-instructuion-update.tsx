import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IRegInstructuion } from 'app/shared/model/reg-instructuion.model';
import { getEntity, updateEntity, createEntity, reset } from './reg-instructuion.reducer';

export const RegInstructuionUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const regInstructuionEntity = useAppSelector(state => state.regInstructuion.entity);
  const loading = useAppSelector(state => state.regInstructuion.loading);
  const updating = useAppSelector(state => state.regInstructuion.updating);
  const updateSuccess = useAppSelector(state => state.regInstructuion.updateSuccess);

  const handleClose = () => {
    navigate('/reg-instructuion' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...regInstructuionEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          ...regInstructuionEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="educationApp.regInstructuion.home.createOrEditLabel" data-cy="RegInstructuionCreateUpdateHeading">
            <Translate contentKey="educationApp.regInstructuion.home.createOrEditLabel">Create or edit a RegInstructuion</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="reg-instructuion-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('educationApp.regInstructuion.titleUz')}
                id="reg-instructuion-titleUz"
                name="titleUz"
                data-cy="titleUz"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.regInstructuion.titleRu')}
                id="reg-instructuion-titleRu"
                name="titleRu"
                data-cy="titleRu"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.regInstructuion.titleKr')}
                id="reg-instructuion-titleKr"
                name="titleKr"
                data-cy="titleKr"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.regInstructuion.contentUz')}
                id="reg-instructuion-contentUz"
                name="contentUz"
                data-cy="contentUz"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.regInstructuion.contentRu')}
                id="reg-instructuion-contentRu"
                name="contentRu"
                data-cy="contentRu"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.regInstructuion.contentKr')}
                id="reg-instructuion-contentKr"
                name="contentKr"
                data-cy="contentKr"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.regInstructuion.status')}
                id="reg-instructuion-status"
                name="status"
                data-cy="status"
                check
                type="checkbox"
              />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/reg-instructuion" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default RegInstructuionUpdate;
