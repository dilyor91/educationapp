import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IAddmissionRules } from 'app/shared/model/addmission-rules.model';
import { getEntity, updateEntity, createEntity, reset } from './addmission-rules.reducer';

export const AddmissionRulesUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const addmissionRulesEntity = useAppSelector(state => state.addmissionRules.entity);
  const loading = useAppSelector(state => state.addmissionRules.loading);
  const updating = useAppSelector(state => state.addmissionRules.updating);
  const updateSuccess = useAppSelector(state => state.addmissionRules.updateSuccess);

  const handleClose = () => {
    navigate('/addmission-rules');
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
      ...addmissionRulesEntity,
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
          ...addmissionRulesEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="educationApp.addmissionRules.home.createOrEditLabel" data-cy="AddmissionRulesCreateUpdateHeading">
            <Translate contentKey="educationApp.addmissionRules.home.createOrEditLabel">Create or edit a AddmissionRules</Translate>
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
                  id="addmission-rules-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('educationApp.addmissionRules.titleUz')}
                id="addmission-rules-titleUz"
                name="titleUz"
                data-cy="titleUz"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.addmissionRules.titleRu')}
                id="addmission-rules-titleRu"
                name="titleRu"
                data-cy="titleRu"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.addmissionRules.titleKr')}
                id="addmission-rules-titleKr"
                name="titleKr"
                data-cy="titleKr"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.addmissionRules.contentUz')}
                id="addmission-rules-contentUz"
                name="contentUz"
                data-cy="contentUz"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.addmissionRules.contentRu')}
                id="addmission-rules-contentRu"
                name="contentRu"
                data-cy="contentRu"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.addmissionRules.contentKr')}
                id="addmission-rules-contentKr"
                name="contentKr"
                data-cy="contentKr"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('educationApp.addmissionRules.status')}
                id="addmission-rules-status"
                name="status"
                data-cy="status"
                check
                type="checkbox"
              />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/addmission-rules" replace color="info">
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

export default AddmissionRulesUpdate;
